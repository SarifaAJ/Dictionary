package com.example.dictionary.ui.kosa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictionary.adapter.KosaAdapter
import com.example.dictionary.databinding.ActivityKosaBinding

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

        kosaViewModel.response.observe(this) { kosaList ->
            kosaAdapter.setData(ArrayList(kosaList))
        }
    }
}