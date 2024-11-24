package com.example.lista3.model

import androidx.recyclerview.widget.RecyclerView
import com.example.lista3.databinding.TasksListItemBinding

class TasksListViewHolder(
    binding: TasksListItemBinding,
    onItemClick: (Int) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.setOnClickListener {
            onItemClick(adapterPosition)
        }
    }
    fun bind() {
//            binding.singleWord.text = item
    }

}