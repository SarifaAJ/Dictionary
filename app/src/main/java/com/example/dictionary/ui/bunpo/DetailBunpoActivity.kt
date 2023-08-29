package com.example.dictionary.ui.bunpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dictionary.databinding.ActivityBunpoDetailBinding
import com.example.dictionary.extention.parseHtml

class DetailBunpoActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityBunpoDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBunpoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back to MainActivity
        binding.backBtn.setOnClickListener {
            finish()
        }

        val id = intent.getStringExtra("bunpo_id")
        val judul = intent.getStringExtra("bunpo_judul")
        val penjelasan = intent.getStringExtra("bunpo_penjelasan")

        // Set your UI components using the retrieved data
        binding.bunpoTitle.text = judul
        binding.bunpoDesc.text = penjelasan!!.parseHtml()

    }
}