package com.example.dictionary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.databinding.KosaItemBinding
import com.example.dictionary.adapter.holder.KosaHolder
import com.example.dictionary.model.KosaResponseItem

class KosaAdapter(var data:ArrayList<KosaResponseItem> = ArrayList()): RecyclerView.Adapter<KosaHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KosaHolder {
        val binding = KosaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KosaHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: KosaHolder, position: Int) {
        holder.setData(data[position])
    }
}