package com.example.dictionary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.adapter.holder.KanjiHolder
import com.example.dictionary.databinding.KanjiItemBinding
import com.example.dictionary.model.KanjiResponseItem
import com.example.dictionary.ui.kanji.KanjiActivity

class KanjiAdapter(private var initialData:ArrayList<KanjiResponseItem> = ArrayList()): RecyclerView.Adapter<KanjiHolder>() {
    private val data = ArrayList(initialData)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KanjiHolder {
        val binding = KanjiItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KanjiHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: KanjiHolder, position: Int) {
        val kanjiItem = data[position]

        // Set up click listener to read Kanji when clicked
        holder.itemView.setOnClickListener {
            val kanjiText = kanjiItem.kanji // Assuming 'kanji' is the property holding the Kanji character
            val context = holder.itemView.context
            (context as? KanjiActivity)?.readKanji(kanjiText)
        }

        holder.setData(kanjiItem)
    }

    fun setData(newData: ArrayList<KanjiResponseItem>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

}