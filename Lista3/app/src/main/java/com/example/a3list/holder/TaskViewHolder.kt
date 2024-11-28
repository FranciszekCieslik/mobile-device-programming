package com.example.a3list.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.a3list.databinding.ItemTaskBinding
import com.example.a3list.model.Exercise

class TaskViewHolder (
    private val binding: ItemTaskBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.setOnClickListener {
            //onItemClick(adapterPosition)
        }
    }
    fun bind(task: Exercise) {
        //task.exercises
        binding.textTaskPoints.text = "pkt: ${task.points}"
        binding.textTaskName.text =  "${task.name}"
        binding.textTaskContent.text = "${task.content}"

        //itemView.setOnClickListener { onTaskClick(task) }
    }
}