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