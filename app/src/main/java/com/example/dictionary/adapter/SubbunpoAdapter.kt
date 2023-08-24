package com.example.dictionary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.adapter.holder.SubbunpoHolder
import com.example.dictionary.databinding.ChapterListItemBinding
import com.example.dictionary.model.SubbunpoResponseItem

class SubbunpoAdapter(var data:ArrayList<SubbunpoResponseItem> = ArrayList()): RecyclerView.Adapter<SubbunpoHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubbunpoHolder {
        val binding = ChapterListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubbunpoHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SubbunpoHolder, position: Int) {
        holder.setData(data[position])
    }
}