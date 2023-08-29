package com.example.dictionary.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.adapter.holder.PenjelasanHolder
import com.example.dictionary.databinding.ChapterListItemBinding
import com.example.dictionary.model.PenjelasanResponseItem
import com.example.dictionary.ui.penjelasan.DetailPenjelasanActivity

class PenjelasanAdapter(private var initialData:ArrayList<PenjelasanResponseItem> = ArrayList()): RecyclerView.Adapter<PenjelasanHolder>() {
    private val data = ArrayList(initialData)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PenjelasanHolder {
        val binding = ChapterListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PenjelasanHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PenjelasanHolder, position: Int) {
        val penjelasan = data[position]
        holder.setData(penjelasan)

        // Set click listener
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailPenjelasanActivity::class.java)
            intent.putExtra("penjelasan_id", penjelasan.id)
            intent.putExtra("penjelasan_judul", penjelasan.judul)
            intent.putExtra("penjelasan_penjelasan", penjelasan.penjelasan)// Pass the level ID to PenjelasanDetailActivity
            holder.itemView.context.startActivity(intent)
        }
    }

    fun setData(newData: ArrayList<PenjelasanResponseItem>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
}
