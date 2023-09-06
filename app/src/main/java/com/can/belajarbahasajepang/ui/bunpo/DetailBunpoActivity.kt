package com.can.belajarbahasajepang.ui.bunpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.can.belajarbahasajepang.databinding.ActivityBunpoDetailBinding
import com.can.belajarbahasajepang.extention.parseHtml
import com.can.belajarbahasajepang.helper.LoadingDialog

class DetailBunpoActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityBunpoDetailBinding
    // dialog
    private lateinit var loadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBunpoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back to MainActivity
        binding.backBtn.setOnClickListener {
            finish()
        }

        val judul = intent.getStringExtra("bunpo_judul")
        val penjelasan = intent.getStringExtra("bunpo_penjelasan")

        // show loading dialog
        loadingDialog = LoadingDialog(this)
        loadingDialog.show()

        // Set your UI components using the retrieved data
        binding.bunpoTitle.text = judul
        binding.bunpoDesc.text = penjelasan!!.parseHtml()

        // dismiss loading dialog
        loadingDialog.dismiss()
    }
}