package com.example.dictionary.ui.penjelasan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictionary.adapter.PenjelasanAdapter
import com.example.dictionary.databinding.ActivityPenjelasanBinding
import com.example.dictionary.model.LevelResponseItem

class PenjelasanActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityPenjelasanBinding
    // view model
    private lateinit var penjelasanViewModel: PenjelasanViewModel
    // adapter
    private lateinit var penjelasanAdapter: PenjelasanAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPenjelasanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back to MainActivity
        binding.backBtn.setOnClickListener {
            finish()
        }

        // Setting up the RecyclerView for displaying data
        val recyclerView = binding.penjelasanRv
        recyclerView.layoutManager = LinearLayoutManager(this)

        penjelasanAdapter = PenjelasanAdapter()
        recyclerView.adapter = penjelasanAdapter

        penjelasanViewModel = ViewModelProvider(this)[PenjelasanViewModel::class.java]
        // Retrieving the LevelResponseItem passed through intent from previous activity
        val levelResponseItem = intent.getParcelableExtra<LevelResponseItem>("levelResponseItem")
        levelResponseItem?.let {
            penjelasanViewModel.getPenjelasan(it.id)
        }

        penjelasanViewModel.response.observe(this) { penjelasanList ->
            penjelasanAdapter.setData(ArrayList(penjelasanList))
        }
    }
}