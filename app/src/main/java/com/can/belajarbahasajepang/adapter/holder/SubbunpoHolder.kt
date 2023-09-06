package com.can.belajarbahasajepang.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.can.belajarbahasajepang.databinding.ChapterListItemBinding
import com.can.belajarbahasajepang.model.SubbunpoResponseItem

class SubbunpoHolder(private var item : ChapterListItemBinding) : RecyclerView.ViewHolder(item.root) {
    fun setData(chapter : SubbunpoResponseItem) {
        item.babText.text = chapter.nama
    }
}