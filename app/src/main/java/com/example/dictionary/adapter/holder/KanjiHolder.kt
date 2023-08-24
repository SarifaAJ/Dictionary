package com.example.dictionary.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.databinding.KanjiItemBinding
import com.example.dictionary.model.KanjiResponseItem

class KanjiHolder(private var item : KanjiItemBinding) : RecyclerView.ViewHolder(item.root) {
    fun setData(content : KanjiResponseItem) {
        item.kanji.text = content.kanji
        item.arti.text = content.arti
        item.kunyomi.text = content.kunyomi
        item.onyomi.text = content.onyomi
    }
}