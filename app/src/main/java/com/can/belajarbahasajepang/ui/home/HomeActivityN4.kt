package com.can.belajarbahasajepang.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.can.belajarbahasajepang.databinding.ActivityHomeN4Binding
import com.can.belajarbahasajepang.model.LevelResponseItem
import com.can.belajarbahasajepang.ui.kanji.KanjiActivity
import com.can.belajarbahasajepang.ui.penjelasan.PenjelasanActivity
import com.can.belajarbahasajepang.ui.subbunpo.SubbunpoActivity
import com.can.belajarbahasajepang.ui.subkosa.SubkosaActivity
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class HomeActivityN4 : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityHomeN4Binding
    // interstitial
    private var mInterstitialAd: InterstitialAd? = null
    private var addCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeN4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // back to MainActivity
        binding.backBtn.setOnClickListener {
            finish()
        }

        // interstitial ads
        MobileAds.initialize(this) {}
        loadAds()

        // btn to SubkosaActivity
        binding.kosaCv.setOnClickListener {
            showAds(SubkosaActivity::class.java)
        }

        // btn to SubbunpoActivity
        binding.bunpoCv.setOnClickListener {
            showAds(SubbunpoActivity::class.java)
        }

        // btn to KanjiActivity
        binding.kanjiCv.setOnClickListener {
            showAds(KanjiActivity::class.java)
        }

        // btn to PenjelasanActivity
        binding.penjelasanCv.setOnClickListener {
            showAds(PenjelasanActivity::class.java)
        }
    }

    private fun navigateToNextActivity(destinationActivity: Class<*>) {
        addCount+=1
        val moveIntent = Intent(this@HomeActivityN4, destinationActivity)
        val levelResponseItem = LevelResponseItem(
            "N4 Level",
            "2020-08-11 08:37:19",
            "2020-08-11 08:37:19",
            "5f31f64f5a55e",
            "User123"
        )
        moveIntent.putExtra("levelResponseItem", levelResponseItem)
        startActivity(moveIntent)
    }

    private fun loadAds() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this, "ca-app-pub-1053226146342475/7594320573", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                mInterstitialAd = interstitialAd
            }
        })
    }

    private fun showAds(destinationActivity: Class<*>) {
        if (mInterstitialAd != null) {
            if (addCount % 5 == 0) {
                mInterstitialAd?.show(this)
                mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        mInterstitialAd = null
                        navigateToNextActivity(destinationActivity)
                    }

                    override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                        mInterstitialAd = null
                        navigateToNextActivity(destinationActivity)
                    }
                }
            }
            else {
                navigateToNextActivity(destinationActivity)
            }
        } else {
            navigateToNextActivity(destinationActivity)
        }
    }
}