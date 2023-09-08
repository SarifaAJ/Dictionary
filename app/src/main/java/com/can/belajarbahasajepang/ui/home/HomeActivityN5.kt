package com.can.belajarbahasajepang.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.can.belajarbahasajepang.databinding.ActivityHomeN5Binding
import com.can.belajarbahasajepang.model.LevelResponseItem
import com.can.belajarbahasajepang.ui.kanji.KanjiActivity
import com.can.belajarbahasajepang.ui.penjelasan.PenjelasanActivity
import com.can.belajarbahasajepang.ui.subbunpo.SubbunpoActivity
import com.can.belajarbahasajepang.ui.subkosa.SubkosaActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class HomeActivityN5 : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityHomeN5Binding
    // banner ads
    private lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeN5Binding.inflate(layoutInflater)
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

        // btn to SubkosaActivity
        binding.kosaCv.setOnClickListener {
            val moveIntent = Intent(this@HomeActivityN5, SubkosaActivity::class.java)
            val levelResponseItem = LevelResponseItem(
                "N5 Level",
                "2020-07-13 03:30:35",
                "2020-07-13 03:30:35",
                "5f0b72ebb3ed3",
                "User123"
            )
            moveIntent.putExtra("levelResponseItem", levelResponseItem)
            startActivity(moveIntent)
        }

        // btn to SubbunpoActivity
        binding.bunpoCv.setOnClickListener {
            val moveIntent = Intent(this@HomeActivityN5, SubbunpoActivity::class.java)
            val levelResponseItem = LevelResponseItem(
                "N5 Level",
                "2020-07-13 03:30:35",
                "2020-07-13 03:30:35",
                "5f0b72ebb3ed3",
                "User123"
            )
            moveIntent.putExtra("levelResponseItem", levelResponseItem)
            startActivity(moveIntent)
        }

        // btn to KanjiActivity
        binding.kanjiCv.setOnClickListener {
            val moveIntent = Intent(this@HomeActivityN5, KanjiActivity::class.java)
            val levelResponseItem = LevelResponseItem(
                "N5 Level",
                "2020-07-13 03:30:35",
                "2020-07-13 03:30:35",
                "5f0b72ebb3ed3",
                "User123"
            )
            moveIntent.putExtra("levelResponseItem", levelResponseItem)
            startActivity(moveIntent)
        }

        // btn to PenjelasanActivity
        binding.penjelasanCv.setOnClickListener {
            val moveIntent = Intent(this@HomeActivityN5, PenjelasanActivity::class.java)
            val levelResponseItem = LevelResponseItem(
                "N5 Level",
                "2020-07-13 03:30:35",
                "2020-07-13 03:30:35",
                "5f0b72ebb3ed3",
                "User123"
            )
            moveIntent.putExtra("levelResponseItem", levelResponseItem)
            startActivity(moveIntent)
        }

    }
}