package com.example.dictionary.ui.kosa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictionary.adapter.KanjiAdapter
import com.example.dictionary.adapter.KosaAdapter
import com.example.dictionary.databinding.ActivityKosaBinding
import com.example.dictionary.model.KosaResponseItem
import com.example.dictionary.network.ClientService
import com.example.dictionary.ui.kanji.KanjiViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KosaActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityKosaBinding
    // view model
    private lateinit var kosaViewModel: KosaViewModel
    // adapter
    private lateinit var kosaAdapter: KosaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKosaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back to MainActivity
        binding.backBtn.setOnClickListener {
            finish()
        }

        // Setting up the RecyclerView for displaying data
        val recyclerView = binding.kosaRv
        recyclerView.layoutManager = LinearLayoutManager(this)

        kosaAdapter = KosaAdapter()
        recyclerView.adapter = kosaAdapter

        kosaViewModel = ViewModelProvider(this)[KosaViewModel::class.java]
        // Retrieving the SubkosaResponseitem id passed through intent from previous activity
        val subkosaId = intent.getStringExtra("subkosa_id")
        subkosaId?.let {
            kosaViewModel.getKosa(it)
        }

        kosaViewModel.response.observe(this) {
            kosaAdapter.data
        }
    }
}