package com.example.dictionary.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.adapter.holder.SubkosaHolder
import com.example.dictionary.databinding.ChapterListItemBinding
import com.example.dictionary.model.SubkosaResponseItem
import com.example.dictionary.ui.kosa.KosaActivity

class SubkosaAdapter(private var initialData:ArrayList<SubkosaResponseItem> = ArrayList()): RecyclerView.Adapter<SubkosaHolder>() {
    private val data = ArrayList(initialData)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubkosaHolder {
        val binding = ChapterListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubkosaHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SubkosaHolder, position: Int) {
        val subkosa = data[position]
        holder.setData(subkosa)

        // Set click listener
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, KosaActivity::class.java)
            intent.putExtra("subkosa_id", subkosa.id) // Pass the level ID to KosaActivity
            holder.itemView.context.startActivity(intent)
        }
    }

    fun setData(newData: ArrayList<SubkosaResponseItem>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
}