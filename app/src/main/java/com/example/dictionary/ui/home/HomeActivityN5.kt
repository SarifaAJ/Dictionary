package com.example.dictionary.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dictionary.databinding.ActivityHomeN5Binding
import com.example.dictionary.model.LevelResponseItem
import com.example.dictionary.ui.kanji.KanjiActivity
import com.example.dictionary.ui.PenjelasanActivity
import com.example.dictionary.ui.bunpo.SubbunpoActivity
import com.example.dictionary.ui.kosa.SubkosaActivity

class HomeActivityN5 : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityHomeN5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeN5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // back to MainActivity
        binding.backBtn.setOnClickListener {
            finish()
        }

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