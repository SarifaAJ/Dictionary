package com.example.dictionary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.adapter.holder.KanjiGridItemHolder
import com.example.dictionary.adapter.holder.KanjiHolderInterface
import com.example.dictionary.adapter.holder.KanjiListItemHolder
import com.example.dictionary.databinding.KanjiListItemBinding
import com.example.dictionary.databinding.KanjiGridItemBinding
import com.example.dictionary.model.KanjiResponseItem
import com.example.dictionary.ui.kanji.KanjiActivity

class KanjiAdapter(private var initialData: ArrayList<KanjiResponseItem> = ArrayList(), private val viewType: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data = ArrayList(initialData)

    companion object {
        const val VIEW_TYPE_LIST = 1
        const val VIEW_TYPE_GRID = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_LIST -> {
                val binding = KanjiListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                KanjiListItemHolder(binding.root)
            }
            VIEW_TYPE_GRID -> {
                val binding = KanjiGridItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                KanjiGridItemHolder(binding.root)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val kanjiItem = data[position] // Assume 'KanjiResponseItem' is your data class

        // Set up click listener to read Kanji when clicked
        holder.itemView.setOnClickListener {
            val kanjiText = kanjiItem.kanji // Assuming 'kanji' is the property holding the Kanji character
            val context = holder.itemView.context
            (context as? KanjiActivity)?.readKanji(kanjiText)
        }

        if (holder is KanjiHolderInterface) {
            holder.bindData(kanjiItem)
        }
    }

    fun setData(newData: ArrayList<KanjiResponseItem>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
}
