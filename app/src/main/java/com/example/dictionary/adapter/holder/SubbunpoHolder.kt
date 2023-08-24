package com.example.dictionary.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.databinding.ChapterListItemBinding
import com.example.dictionary.model.SubbunpoResponseItem

class SubbunpoHolder(private var item : ChapterListItemBinding) : RecyclerView.ViewHolder(item.root) {
    fun setData(chapter : SubbunpoResponseItem) {
        item.babText.text = chapter.nama
    }
}