package com.example.a3list.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.a3list.ExerciseList
import com.example.a3list.databinding.ItemTaskListBinding

class TaskListViewHolder (
    private val binding: ItemTaskListBinding,
    onItemClick: (Int) -> Unit
    ) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.setOnClickListener {
            onItemClick(adapterPosition)
        }
    }
    fun bind(task: ExerciseList) {

        binding.textTaskListSubjectName.text = task.subject
        binding.textTaskListName.text = "Liczba zadań: ${task.exercises.size}"
        binding.textTaskListGrade.text = "Ocena: ${task.grade}"
        binding.textTaskListCounter.text = task.name

    }
}