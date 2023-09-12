package com.can.belajarbahasajepang.ui.subkosa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.can.belajarbahasajepang.databinding.ActivitySubkosaBinding
import com.can.belajarbahasajepang.adapter.SubkosaAdapter
import com.can.belajarbahasajepang.helper.LoadingDialog
import com.can.belajarbahasajepang.model.LevelResponseItem
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class SubkosaActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivitySubkosaBinding
    // view model
    private lateinit var subkosaViewModel: SubkosaViewModel
    // adapter
    private lateinit var subkosaAdapter: SubkosaAdapter
    // dialog
    private lateinit var loadingDialog: LoadingDialog
    // banner ads
    private lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubkosaBinding.inflate(layoutInflater)
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
        val recyclerView = binding.subkosaRv
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        subkosaAdapter = SubkosaAdapter()
        recyclerView.adapter = subkosaAdapter

        // loading dialog
        loadingDialog = LoadingDialog(this) // Initialize loading dialog

        // Setting up ViewModel
        subkosaViewModel = ViewModelProvider(this)[SubkosaViewModel::class.java]
        val levelResponseItem = intent.getParcelableExtra<LevelResponseItem>("levelResponseItem")
        levelResponseItem?.let {
            loadingDialog.show()
            subkosaViewModel.getSubkosa(it.id) // Pass the idLevel to the ViewModel
        }

        subkosaViewModel.response.observe(this) {subkosaList ->
            loadingDialog.dismiss()
            subkosaAdapter.setData(ArrayList(subkosaList))
        }
    }
}
