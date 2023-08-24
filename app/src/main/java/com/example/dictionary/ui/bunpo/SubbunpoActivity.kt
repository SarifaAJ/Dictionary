package com.example.dictionary.ui.bunpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dictionary.adapter.SubbunpoAdapter
import com.example.dictionary.databinding.ActivitySubbunpoBinding
import com.example.dictionary.model.LevelResponseItem
import com.example.dictionary.model.SubbunpoResponseItem
import com.example.dictionary.network.ClientService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubbunpoActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivitySubbunpoBinding
    // view model
    private lateinit var subbunpoViewModel: SubbunpoViewModel
    // adapter
    private lateinit var subbunpoAdapter: SubbunpoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubbunpoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back to MainActivity
        binding.backBtn.setOnClickListener {
            finish()
        }

        // Setting up the RecyclerView for displaying data
        val recyclerView = binding.subbunpoRv
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        subbunpoAdapter = SubbunpoAdapter()
        recyclerView.adapter = subbunpoAdapter

        subbunpoViewModel = ViewModelProvider(this)[SubbunpoViewModel::class.java]
        val levelResponseItem = intent.getParcelableExtra<LevelResponseItem>("levelResponseItem")
        levelResponseItem?.let {
            subbunpoViewModel.getSubbunpo(it.id)
        }

        subbunpoViewModel.response.observe(this) {
            subbunpoAdapter.data
        }
    }
}