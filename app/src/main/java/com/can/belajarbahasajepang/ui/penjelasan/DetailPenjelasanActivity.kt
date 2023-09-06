package com.can.belajarbahasajepang.ui.penjelasan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.can.belajarbahasajepang.databinding.ActivityPenjelasanDetailBinding
import com.can.belajarbahasajepang.extention.parseHtml
import com.can.belajarbahasajepang.helper.LoadingDialog

class DetailPenjelasanActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityPenjelasanDetailBinding
    // dialog
    private lateinit var loadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPenjelasanDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back to MainActivity
        binding.backBtn.setOnClickListener {
            finish()
        }

        val judul = intent.getStringExtra("penjelasan_judul")
        val penjelasan = intent.getStringExtra("penjelasan_penjelasan")

        // show loading dialog
        loadingDialog = LoadingDialog(this)
        loadingDialog.show()

        // Set your UI components using the retrieved data
        binding.penjelasanTitle.text = judul
        binding.penjelasanDesc.text = penjelasan!!.parseHtml()

        // dismiss loading dialog
        loadingDialog.dismiss()
    }
}