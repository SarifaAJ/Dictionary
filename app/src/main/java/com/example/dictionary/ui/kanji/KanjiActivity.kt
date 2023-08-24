package com.example.dictionary.ui.kanji

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictionary.adapter.KanjiAdapter
import com.example.dictionary.adapter.KosaAdapter
import com.example.dictionary.databinding.ActivityKanjiBinding
import com.example.dictionary.model.KanjiResponseItem
import com.example.dictionary.model.LevelResponseItem
import com.example.dictionary.network.ClientService
import com.example.dictionary.ui.kosa.KosaViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KanjiActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityKanjiBinding
    // view model
    private lateinit var kanjiViewModel: KanjiViewModel
    // adapter
    private lateinit var kanjiAdapter: KanjiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKanjiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back to MainActivity
        binding.backBtn.setOnClickListener {
            finish()
        }

        // Setting up the RecyclerView for displaying data
        val recyclerView = binding.kanjiRv
        recyclerView.layoutManager = LinearLayoutManager(this)

        kanjiAdapter = KanjiAdapter()
        recyclerView.adapter = kanjiAdapter

        kanjiViewModel = ViewModelProvider(this)[KanjiViewModel::class.java]
        // Retrieving the LevelResponseItem passed through intent from previous activity
        val levelResponseItem = intent.getParcelableExtra<LevelResponseItem>("levelResponseItem")
        levelResponseItem?.let {
            kanjiViewModel.getKanji(it.id)
        }

        kanjiViewModel.response.observe(this) {
            kanjiAdapter.data
        }
    }
}