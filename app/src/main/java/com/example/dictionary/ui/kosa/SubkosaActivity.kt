package com.example.dictionary.ui.kosa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dictionary.adapter.SubkosaAdapter
import com.example.dictionary.databinding.ActivitySubkosaBinding
import com.example.dictionary.model.LevelResponseItem

class SubkosaActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivitySubkosaBinding
    // view model
    private lateinit var subkosaViewModel: SubkosaViewModel
    // adapter
    private lateinit var subkosaAdapter: SubkosaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubkosaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back to MainActivity
        binding.backBtn.setOnClickListener {
            finish()
        }

        // Setting up the RecyclerView for displaying data
        val recyclerView = binding.subkosaRv
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        subkosaAdapter = SubkosaAdapter()
        recyclerView.adapter = subkosaAdapter

        subkosaViewModel = ViewModelProvider(this)[SubkosaViewModel::class.java]
        val levelResponseItem = intent.getParcelableExtra<LevelResponseItem>("levelResponseItem")
        levelResponseItem?.let {
            subkosaViewModel.getSubkosa(it.id) // Pass the idLevel to the ViewModel
        }

        subkosaViewModel.response.observe(this) {subkosaList ->
            subkosaAdapter.setData(ArrayList(subkosaList))
        }
    }
}
