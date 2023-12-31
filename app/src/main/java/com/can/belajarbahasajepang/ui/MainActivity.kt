package com.can.belajarbahasajepang.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.can.belajarbahasajepang.databinding.ActivityMainBinding
import com.can.belajarbahasajepang.ui.home.HomeActivityN4
import com.can.belajarbahasajepang.ui.home.HomeActivityN5

class MainActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.n5Button.setOnClickListener {
            val moveIntent = Intent(this@MainActivity, HomeActivityN5::class.java)
            startActivity(moveIntent)
        }

        binding.n4Button.setOnClickListener {
            val moveIntent = Intent(this@MainActivity, HomeActivityN4::class.java)
            startActivity(moveIntent)
        }
    }
}