package com.can.belajarbahasajepang.ui.kanji

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.can.belajarbahasajepang.R
import com.can.belajarbahasajepang.databinding.ActivityKanjiBinding
import com.can.belajarbahasajepang.adapter.KanjiAdapter
import com.can.belajarbahasajepang.helper.LoadingDialog
import com.can.belajarbahasajepang.model.LevelResponseItem
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import java.util.Locale

class KanjiActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityKanjiBinding
    // view model
    private lateinit var kanjiViewModel: KanjiViewModel
    // adapter
    private lateinit var kanjiAdapter: KanjiAdapter
    private var isListView = true
    // dialog
    private lateinit var loadingDialog: LoadingDialog
    // text to speech
    private lateinit var textToSpeech: TextToSpeech
    // banner ads
    private lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKanjiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back to MainActivity
        binding.backBtn.setOnClickListener {
            finish()
        }

        // google banner ads
        MobileAds.initialize(this) {}

        mAdView = binding.adView
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        // Toggle view between list and grid when btn_list is clicked
        binding.btnList.setOnClickListener {
            isListView = !isListView
            toggleRecyclerViewLayout()
        }

        // Setting up the RecyclerView for displaying data
        val recyclerView = binding.kanjiRv
        recyclerView.layoutManager = LinearLayoutManager(this)
        kanjiAdapter = KanjiAdapter(viewType = KanjiAdapter.VIEW_TYPE_LIST) // Atau viewType = KanjiAdapter.VIEW_TYPE_GRID sesuai kebutuhan
        recyclerView.adapter = kanjiAdapter

        // loading dialog
        loadingDialog = LoadingDialog(this) // Inisialisasi loading dialog

        // Setting up ViewModel
        kanjiViewModel = ViewModelProvider(this)[KanjiViewModel::class.java]
        val levelResponseItem = intent.getParcelableExtra<LevelResponseItem>("levelResponseItem")
        levelResponseItem?.let {
            loadingDialog.show() // Tampilkan loading dialog sebelum mengambil data
            kanjiViewModel.getKanji(it.id)
        }

        kanjiViewModel.response.observe(this) { kanjiList ->
            loadingDialog.dismiss() // Sembunyikan dialog setelah mendapatkan respons
            kanjiAdapter.setData(ArrayList(kanjiList))
        }

        // Initialize Text-to-Speech engine
        textToSpeech = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val locale = Locale("ja", "JP") // Japanese locale
                val result = textToSpeech.setLanguage(locale)

                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    // Language data is missing or not supported, handle accordingly
                }
            } else {
                // Text-to-Speech initialization failed, handle accordingly
            }
        }
    }

    private fun toggleRecyclerViewLayout() {
        val recyclerView = binding.kanjiRv

        if (isListView) {
            recyclerView.layoutManager = LinearLayoutManager(this)
            binding.btnList.setImageResource(R.drawable.round_view_list_24) // Ganti gambar menjadi ikon list
            kanjiAdapter = KanjiAdapter(initialData = ArrayList(), viewType = KanjiAdapter.VIEW_TYPE_LIST)
        } else {
            recyclerView.layoutManager = GridLayoutManager(this, 2) // Atur numberOfColumns sesuai kebutuhan
            binding.btnList.setImageResource(R.drawable.round_grid_view_24) // Ganti gambar menjadi ikon grid
            kanjiAdapter = KanjiAdapter(initialData = ArrayList(), viewType = KanjiAdapter.VIEW_TYPE_GRID)
        }

        recyclerView.adapter = kanjiAdapter
        kanjiAdapter.setData(ArrayList(kanjiViewModel.response.value!!)) // Set data ulang ke adapter
    }

    // Function to read a Kanji using Text-to-Speech
    fun readKanji(text: String) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }
}