package com.example.dictionary.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dictionary.databinding.ActivityHomeN4Binding
import com.example.dictionary.model.LevelResponseItem
import com.example.dictionary.ui.kanji.KanjiActivity
import com.example.dictionary.ui.PenjelasanActivity
import com.example.dictionary.ui.bunpo.SubbunpoActivity
import com.example.dictionary.ui.kosa.SubkosaActivity

class HomeActivityN4 : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityHomeN4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeN4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // back to MainActivity
        binding.backBtn.setOnClickListener {
            finish()
        }

        // btn to SubkosaActivity
        binding.kosaCv.setOnClickListener {
            val moveIntent = Intent(this@HomeActivityN4, SubkosaActivity::class.java)
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

        // btn to SubbunpoActivity
        binding.bunpoCv.setOnClickListener {
            val moveIntent = Intent(this@HomeActivityN4, SubbunpoActivity::class.java)
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

        // btn to KanjiActivity
        binding.kanjiCv.setOnClickListener {
            val moveIntent = Intent(this@HomeActivityN4, KanjiActivity::class.java)
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

        // btn to PenjelasanActivity
        binding.penjelasanCv.setOnClickListener {
            val moveIntent = Intent(this@HomeActivityN4, PenjelasanActivity::class.java)
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
    }
}