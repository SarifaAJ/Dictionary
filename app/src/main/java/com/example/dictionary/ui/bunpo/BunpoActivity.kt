package com.example.dictionary.ui.bunpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictionary.adapter.BunpoAdapter
import com.example.dictionary.databinding.ActivityBunpoBinding

class BunpoActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityBunpoBinding
    // view model
    private lateinit var bunpoViewModel: BunpoViewModel
    // adapter
    private lateinit var bunpoAdapter: BunpoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBunpoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back to MainActivity
        binding.backBtn.setOnClickListener {
            finish()
        }

        // Setting up the RecyclerView for displaying data
        val recyclerView = binding.bunpoRv
        recyclerView.layoutManager = LinearLayoutManager(this)

        bunpoAdapter = BunpoAdapter()
        recyclerView.adapter = bunpoAdapter

        bunpoViewModel = ViewModelProvider(this)[BunpoViewModel::class.java]
        // Retrieving the SubbunpoResponseItem id passed through intent from previous activity
        val subbunpoId = intent.getStringExtra("subbunpo_id")
        subbunpoId?.let {
            bunpoViewModel.getBunpo(it)
        }

        bunpoViewModel.response.observe(this) {bunpoList ->
            bunpoAdapter.setData(ArrayList(bunpoList))
        }
    }
}