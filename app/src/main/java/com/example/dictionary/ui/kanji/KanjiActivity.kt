package com.example.dictionary.ui.kanji

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictionary.R
import com.example.dictionary.adapter.KanjiAdapter
import com.example.dictionary.databinding.ActivityKanjiBinding
import com.example.dictionary.databinding.KanjiItemBinding
import com.example.dictionary.helper.LoadingDialog
import com.example.dictionary.model.LevelResponseItem
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

    private lateinit var textToSpeech: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKanjiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back to MainActivity
        binding.backBtn.setOnClickListener {
            finish()
        }

        // Toggle view between list and grid when btn_list is clicked
        binding.btnList.setOnClickListener {
            isListView = !isListView
            toggleRecyclerViewLayout()
        }

        // Setting up the RecyclerView for displaying data
        val recyclerView = binding.kanjiRv
        recyclerView.layoutManager = LinearLayoutManager(this)
        kanjiAdapter = KanjiAdapter()
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
            binding.btnList.setImageResource(R.drawable.round_view_list_24) // Ganti gambar menjadi ikon grid
        } else {
            recyclerView.layoutManager = GridLayoutManager(this, 2) // Atur numberOfColumns sesuai kebutuhan
            binding.btnList.setImageResource(R.drawable.round_grid_view_24) // Ganti gambar menjadi ikon list
        }

        kanjiAdapter.notifyDataSetChanged()
    }

    // Function to read a Kanji using Text-to-Speech
    fun readKanji(text: String) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }
}