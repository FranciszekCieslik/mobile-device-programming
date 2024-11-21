package com.example.lista3.model

import androidx.recyclerview.widget.RecyclerView
import com.example.lista3.databinding.WordListItemBinding

class WordListViewHolder(
    private val binding: WordListItemBinding,
    onItemClick: (Int) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.setOnClickListener {
            onItemClick(adapterPosition)
        }
    }
    fun bind(item: String) {
            binding.singleWord.text = item
    }

}