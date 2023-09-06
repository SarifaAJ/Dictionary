package com.can.belajarbahasajepang.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.can.belajarbahasajepang.databinding.KosaItemBinding
import com.can.belajarbahasajepang.model.KosaResponseItem

class KosaHolder(private var item : KosaItemBinding) : RecyclerView.ViewHolder(item.root) {
    fun setData(content : KosaResponseItem) {
        // hiragana
        if (content.hiragana.isEmpty()) {
            item.hiragana.visibility = View.GONE
        } else {
            item.hiragana.visibility = View.VISIBLE
            item.hiragana.text = content.hiragana
        }
        // kanji
        if (content.kanji.isEmpty()) {
            item.kanji.visibility = View.GONE
        } else {
            item.kanji.visibility = View.VISIBLE
            item.kanji.text = content.kanji
        }
        // romaji
        if (content.romanji.isEmpty()) {
            item.romaji.visibility = View.GONE
        } else {
            item.romaji.visibility = View.VISIBLE
            item.romaji.text = content.romanji
        }
        // arti
        if (content.arti.isEmpty()) {
            item.arti.visibility = View.GONE
        } else {
            item.arti.visibility = View.VISIBLE
            item.arti.text = content.arti
        }
    }
}