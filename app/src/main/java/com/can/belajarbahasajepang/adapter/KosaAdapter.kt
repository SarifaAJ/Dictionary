package com.can.belajarbahasajepang.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.can.belajarbahasajepang.databinding.KosaItemBinding
import com.can.belajarbahasajepang.adapter.holder.KosaHolder
import com.can.belajarbahasajepang.model.KosaResponseItem

class KosaAdapter(private var initialData:ArrayList<KosaResponseItem> = ArrayList()): RecyclerView.Adapter<KosaHolder>() {
    private val data = ArrayList(initialData)
    private val filteredData = ArrayList<KosaResponseItem>()

    init {
        filteredData.addAll(initialData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KosaHolder {
        val binding = KosaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KosaHolder(binding)
    }

    override fun getItemCount(): Int {
        return filteredData.size
    }

    override fun onBindViewHolder(holder: KosaHolder, position: Int) {
        holder.setData(filteredData[position])
    }

    fun filter(query: String) {
        filteredData.clear()

        if (query.isEmpty()) {
            filteredData.addAll(data)
        } else {
            val lowerCaseQuery = query.toLowerCase()
            for (item in data) {
                if (item.arti.toLowerCase().contains(lowerCaseQuery)) {
                    filteredData.add(item)
                }
            }
        }

        notifyDataSetChanged()
    }
    fun setData(newData: ArrayList<KosaResponseItem>) {
        data.clear()
        data.addAll(newData)

        filteredData.clear()
        filteredData.addAll(data)

        notifyDataSetChanged()
    }
}