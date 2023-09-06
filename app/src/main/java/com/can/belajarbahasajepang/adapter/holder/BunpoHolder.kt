package com.can.belajarbahasajepang.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.can.belajarbahasajepang.databinding.ChapterListItemBinding
import com.can.belajarbahasajepang.model.BunpoResponseItem

class BunpoHolder(private var item : ChapterListItemBinding) : RecyclerView.ViewHolder(item.root) {
    fun setData(subChapter : BunpoResponseItem) {
        item.babText.text = subChapter.judul
    }
}