package com.can.belajarbahasajepang.ui.kosa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.can.belajarbahasajepang.databinding.ActivityKosaBinding
import com.can.belajarbahasajepang.adapter.KosaAdapter
import com.can.belajarbahasajepang.helper.LoadingDialog
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class KosaActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityKosaBinding
    // view model
    private lateinit var kosaViewModel: KosaViewModel
    // adapter
    private lateinit var kosaAdapter: KosaAdapter
    // dialog
    private lateinit var loadingDialog: LoadingDialog
    // banner ads
    private lateinit var mAdView : AdView

    private fun clearSearchView() {
        binding.searchView.setQuery("", false)
        kosaAdapter.filter("") // Show all data
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKosaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back to MainActivity
        binding.backBtn.setOnClickListener {
            finish()
        }

        // google banner ads
        MobileAds.initialize(this) {}

        mAdView = binding.adView
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        // Setting up the RecyclerView for displaying data
        val recyclerView = binding.kosaRv
        recyclerView.layoutManager = LinearLayoutManager(this)
        kosaAdapter = KosaAdapter()
        recyclerView.adapter = kosaAdapter

        // loading dialog
        loadingDialog = LoadingDialog(this) // Initialize loading dialog

        // Setting up ViewModel
        kosaViewModel = ViewModelProvider(this)[KosaViewModel::class.java]
        // Retrieving the SubkosaResponseItem id passed through intent from previous activity
        val subkosaId = intent.getStringExtra("subkosa_id")
        subkosaId?.let {
            loadingDialog.show()
            kosaViewModel.getKosa(it)
        }

        kosaViewModel.response.observe(this) { kosaList ->
            loadingDialog.dismiss()
            kosaAdapter.setData(ArrayList(kosaList))
        }

        // Clear search view and show all data initially
        clearSearchView()

        // Set up search view listener
        val searchView = binding.searchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    kosaAdapter.filter(it)
                }
                return true
            }
        })
    }
}