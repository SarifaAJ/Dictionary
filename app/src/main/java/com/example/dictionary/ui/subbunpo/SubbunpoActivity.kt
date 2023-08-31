package com.example.dictionary.ui.subbunpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dictionary.adapter.SubbunpoAdapter
import com.example.dictionary.databinding.ActivitySubbunpoBinding
import com.example.dictionary.helper.LoadingDialog
import com.example.dictionary.model.LevelResponseItem

class SubbunpoActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivitySubbunpoBinding
    // view model
    private lateinit var subbunpoViewModel: SubbunpoViewModel
    // adapter
    private lateinit var subbunpoAdapter: SubbunpoAdapter
    // dialog
    private lateinit var loadingDialog: LoadingDialog

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

        // loading dialog
        loadingDialog = LoadingDialog(this) // Inisialisasi loading dialog

        // Setting up ViewModel
        subbunpoViewModel = ViewModelProvider(this)[SubbunpoViewModel::class.java]
        val levelResponseItem = intent.getParcelableExtra<LevelResponseItem>("levelResponseItem")
        levelResponseItem?.let {
            loadingDialog.show()
            subbunpoViewModel.getSubbunpo(it.id)
        }

        subbunpoViewModel.response.observe(this) { subbunpoList ->
            loadingDialog.dismiss()
            subbunpoAdapter.setData(ArrayList(subbunpoList))
        }
    }
}