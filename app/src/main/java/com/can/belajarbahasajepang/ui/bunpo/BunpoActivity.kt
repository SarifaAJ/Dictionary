package com.can.belajarbahasajepang.ui.bunpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.can.belajarbahasajepang.databinding.ActivityBunpoBinding
import com.can.belajarbahasajepang.helper.LoadingDialog

class BunpoActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityBunpoBinding
    // view model
    private lateinit var bunpoViewModel: BunpoViewModel
    // adapter
    private lateinit var bunpoAdapter: com.can.belajarbahasajepang.adapter.BunpoAdapter
    // dialog
    private lateinit var loadingDialog: LoadingDialog

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

        bunpoAdapter = com.can.belajarbahasajepang.adapter.BunpoAdapter()
        recyclerView.adapter = bunpoAdapter

        // loading dialog
        loadingDialog = LoadingDialog(this) // Inisialisasi loading dialog

        // Setting up ViewModel
        bunpoViewModel = ViewModelProvider(this)[BunpoViewModel::class.java]
        // Retrieving the SubbunpoResponseItem id passed through intent from previous activity
        val subbunpoId = intent.getStringExtra("subbunpo_id")
        subbunpoId?.let {
            loadingDialog.show()
            bunpoViewModel.getBunpo(it)
        }

        bunpoViewModel.response.observe(this) {bunpoList ->
            loadingDialog.dismiss()
            bunpoAdapter.setData(ArrayList(bunpoList))
        }
    }
}