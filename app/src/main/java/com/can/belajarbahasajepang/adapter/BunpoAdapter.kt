package com.can.belajarbahasajepang.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.can.belajarbahasajepang.databinding.ChapterListItemBinding
import com.can.belajarbahasajepang.adapter.holder.BunpoHolder
import com.can.belajarbahasajepang.model.BunpoResponseItem
import com.can.belajarbahasajepang.ui.bunpo.DetailBunpoActivity

class BunpoAdapter(private var initialData:ArrayList<BunpoResponseItem> = ArrayList()): RecyclerView.Adapter<BunpoHolder>() {
    private val data = ArrayList(initialData)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BunpoHolder {
        val binding = ChapterListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BunpoHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BunpoHolder, position: Int) {
        val bunpo = data[position]
        holder.setData(bunpo)

        // Set click listener
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailBunpoActivity::class.java)
            intent.putExtra("bunpo_id", bunpo.id)
            intent.putExtra("bunpo_judul", bunpo.judul)
            intent.putExtra("bunpo_penjelasan", bunpo.penjelasan)// Pass the level ID to BunpoDetailActivity
            holder.itemView.context.startActivity(intent)
        }
    }

    fun setData(newData: ArrayList<BunpoResponseItem>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
}