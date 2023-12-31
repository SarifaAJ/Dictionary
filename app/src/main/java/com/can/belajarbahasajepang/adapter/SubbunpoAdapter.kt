package com.can.belajarbahasajepang.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.can.belajarbahasajepang.databinding.ChapterListItemBinding
import com.can.belajarbahasajepang.adapter.holder.SubbunpoHolder
import com.can.belajarbahasajepang.model.SubbunpoResponseItem
import com.can.belajarbahasajepang.ui.bunpo.BunpoActivity

class SubbunpoAdapter(private var initialData:ArrayList<SubbunpoResponseItem> = ArrayList()): RecyclerView.Adapter<SubbunpoHolder>() {
    private val data = ArrayList(initialData)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubbunpoHolder {
        val binding = ChapterListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubbunpoHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SubbunpoHolder, position: Int) {
        val subbunpo = data[position]
        holder.setData(subbunpo)

        // Set click listener
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, BunpoActivity::class.java)
            intent.putExtra("subbunpo_id", subbunpo.id) // Pass the level ID to BunpoActivity
            holder.itemView.context.startActivity(intent)
        }
    }

    fun setData(newData: ArrayList<SubbunpoResponseItem>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
}