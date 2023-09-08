package com.can.belajarbahasajepang.ui.penjelasan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.can.belajarbahasajepang.databinding.ActivityPenjelasanBinding
import com.can.belajarbahasajepang.adapter.PenjelasanAdapter
import com.can.belajarbahasajepang.helper.LoadingDialog
import com.can.belajarbahasajepang.model.LevelResponseItem
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class PenjelasanActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityPenjelasanBinding
    // view model
    private lateinit var penjelasanViewModel: PenjelasanViewModel
    // adapter
    private lateinit var penjelasanAdapter: PenjelasanAdapter
    // dialog
    private lateinit var loadingDialog: LoadingDialog
    // banner ads
    private lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPenjelasanBinding.inflate(layoutInflater)
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
        val recyclerView = binding.penjelasanRv
        recyclerView.layoutManager = LinearLayoutManager(this)

        penjelasanAdapter = PenjelasanAdapter()
        recyclerView.adapter = penjelasanAdapter

        // loading dialog
        loadingDialog = LoadingDialog(this) // Inisialisasi loading dialog

        // Setting up ViewModel
        penjelasanViewModel = ViewModelProvider(this)[PenjelasanViewModel::class.java]
        // Retrieving the LevelResponseItem passed through intent from previous activity
        val levelResponseItem = intent.getParcelableExtra<LevelResponseItem>("levelResponseItem")
        levelResponseItem?.let {
            loadingDialog.show()
            penjelasanViewModel.getPenjelasan(it.id)
        }

        penjelasanViewModel.response.observe(this) { penjelasanList ->
            loadingDialog.dismiss()
            penjelasanAdapter.setData(ArrayList(penjelasanList))
        }
    }
}