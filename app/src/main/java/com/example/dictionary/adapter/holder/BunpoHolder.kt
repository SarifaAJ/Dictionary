package com.example.dictionary.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.databinding.ChapterListItemBinding
import com.example.dictionary.model.BunpoResponseItem

class BunpoHolder(private var item : ChapterListItemBinding) : RecyclerView.ViewHolder(item.root) {
    fun setData(subChapter : BunpoResponseItem) {
        item.babText.text = subChapter.judul
    }
}