package com.example.dictionary.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.databinding.ChapterListItemBinding
import com.example.dictionary.model.SubkosaResponseItem

class SubkosaHolder(private var item : ChapterListItemBinding) : RecyclerView.ViewHolder(item.root) {
    fun setData(chapter : SubkosaResponseItem) {
        item.babText.text = chapter.nama
    }
}