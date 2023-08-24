package com.example.dictionary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.adapter.holder.KanjiHolder
import com.example.dictionary.databinding.KanjiItemBinding
import com.example.dictionary.model.KanjiResponseItem

class KanjiAdapter(var data:ArrayList<KanjiResponseItem> = ArrayList()): RecyclerView.Adapter<KanjiHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KanjiHolder {
        val binding = KanjiItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KanjiHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: KanjiHolder, position: Int) {
        holder.setData(data[position])
    }
}