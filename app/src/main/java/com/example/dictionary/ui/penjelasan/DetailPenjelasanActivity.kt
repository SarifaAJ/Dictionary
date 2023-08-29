package com.example.dictionary.ui.penjelasan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dictionary.databinding.ActivityPenjelasanDetailBinding
import com.example.dictionary.extention.parseHtml

class DetailPenjelasanActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityPenjelasanDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPenjelasanDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back to MainActivity
        binding.backBtn.setOnClickListener {
            finish()
        }

        val id = intent.getStringExtra("penjelasan_id")
        val judul = intent.getStringExtra("penjelasan_judul")
        val penjelasan = intent.getStringExtra("penjelasan_penjelasan")

        // Set your UI components using the retrieved data
        binding.penjelasanTitle.text = judul
        binding.penjelasanDesc.text = penjelasan!!.parseHtml()

    }
}