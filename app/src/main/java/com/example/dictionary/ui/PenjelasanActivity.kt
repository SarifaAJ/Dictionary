package com.example.dictionary.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dictionary.databinding.ActivityPenjelasanBinding

class PenjelasanActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityPenjelasanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPenjelasanBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}