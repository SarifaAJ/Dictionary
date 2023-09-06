package com.can.belajarbahasajepang.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.can.belajarbahasajepang.databinding.KanjiGridItemBinding
import com.can.belajarbahasajepang.databinding.KanjiListItemBinding
import com.can.belajarbahasajepang.model.KanjiResponseItem

interface KanjiHolderInterface {
    fun bindData(content: KanjiResponseItem)
}

class KanjiListItemHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView), KanjiHolderInterface {
    private val binding = KanjiListItemBinding.bind(itemView)

    override fun bindData(content: KanjiResponseItem) {
        with(binding) {
            // Bind data to your views here
            // kanji
            if (content.kanji.isEmpty()) {
                kanji.visibility = View.GONE
            } else {
                kanji.visibility = View.VISIBLE
                kanji.text = content.kanji
            }
            // arti
            if (content.arti.isEmpty()) {
                arti.visibility = View.GONE
            } else {
                arti.visibility = View.VISIBLE
                arti.text = content.arti
            }
            // kunyomi
            if (content.kunyomi.isEmpty()) {
                kunyomi.visibility = View.GONE
            } else {
                kunyomi.visibility = View.VISIBLE
                kunyomi.text = content.kunyomi
            }
            // onyomi
            if (content.onyomi.isEmpty()) {
                onyomi.visibility = View.GONE
            } else {
                onyomi.visibility = View.VISIBLE
                onyomi.text = content.onyomi
            }
        }
    }
}

class KanjiGridItemHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView), KanjiHolderInterface {
    private val binding = KanjiGridItemBinding.bind(itemView)

    override fun bindData(content: KanjiResponseItem) {
        with(binding) {
            // Bind data to your views here
            // kanji
            if (content.kanji.isEmpty()) {
                kanji.visibility = View.GONE
            } else {
                kanji.visibility = View.VISIBLE
                kanji.text = content.kanji
            }
            // arti
            if (content.arti.isEmpty()) {
                arti.visibility = View.GONE
            } else {
                arti.visibility = View.VISIBLE
                arti.text = content.arti
            }
            // kunyomi
            if (content.kunyomi.isEmpty()) {
                kunyomi.visibility = View.GONE
            } else {
                kunyomi.visibility = View.VISIBLE
                kunyomi.text = content.kunyomi
            }
            // onyomi
            if (content.onyomi.isEmpty()) {
                onyomi.visibility = View.GONE
            } else {
                onyomi.visibility = View.VISIBLE
                onyomi.text = content.onyomi
            }
        }
    }
}
