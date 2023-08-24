package com.example.dictionary.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.databinding.KosaItemBinding
import com.example.dictionary.model.KosaResponseItem

class KosaHolder(private var item : KosaItemBinding) : RecyclerView.ViewHolder(item.root) {
    fun setData(content : KosaResponseItem) {
        item.hiragana.text = content.hiragana
        item.kanji.text = content.kanji
        item.romaji.text = content.romanji
        item.arti.text = content.arti
    }
}