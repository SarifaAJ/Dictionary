package com.example.dictionary.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.databinding.KanjiItemBinding
import com.example.dictionary.model.KanjiResponseItem

class KanjiHolder(private var item : KanjiItemBinding) : RecyclerView.ViewHolder(item.root) {
    fun setData(content : KanjiResponseItem) {
        // kanji
        if (content.kanji.isEmpty()) {
            item.kanji.visibility = View.GONE
        } else {
            item.kanji.visibility = View.VISIBLE
            item.kanji.text = content.kanji
        }
        // arti
        if (content.arti.isEmpty()) {
            item.arti.visibility = View.GONE
        } else {
            item.arti.visibility = View.VISIBLE
            item.arti.text = content.arti
        }
        // kunyomi
        if (content.kunyomi.isEmpty()) {
            item.kunyomi.visibility = View.GONE
        } else {
            item.kunyomi.visibility = View.VISIBLE
            item.kunyomi.text = content.kunyomi
        }
        //onyomi
        if (content.onyomi.isEmpty()) {
            item.onyomi.visibility = View.GONE
        } else {
            item.onyomi.visibility = View.VISIBLE
            item.onyomi.text = content.onyomi
        }
    }
}