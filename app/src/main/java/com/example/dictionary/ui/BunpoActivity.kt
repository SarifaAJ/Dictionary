package com.example.dictionary.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dictionary.databinding.ActivityBunpoBinding

class BunpoActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityBunpoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBunpoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}