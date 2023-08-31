package com.example.dictionary.ui.bunpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dictionary.databinding.ActivityBunpoDetailBinding
import com.example.dictionary.extention.parseHtml
import com.example.dictionary.helper.LoadingDialog

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

        val id = intent.getStringExtra("bunpo_id")
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