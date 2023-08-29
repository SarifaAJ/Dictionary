package com.example.dictionary.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.databinding.ChapterListItemBinding
import com.example.dictionary.model.PenjelasanResponseItem

class PenjelasanHolder(private var item : ChapterListItemBinding) : RecyclerView.ViewHolder(item.root) {
    fun setData(subChapter : PenjelasanResponseItem) {
        item.babText.text = subChapter.judul
    }
}
