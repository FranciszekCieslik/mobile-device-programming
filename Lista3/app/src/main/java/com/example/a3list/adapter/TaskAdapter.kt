package com.example.a3list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a3list.databinding.ItemTaskBinding
import com.example.a3list.holder.TaskViewHolder
import com.example.a3list.model.Exercise

class TaskAdapter(
    private val tasks: List<Exercise>,
    private val onTaskClick: (ExerciseList) -> Unit // Callback na kliknięcie elementu
) : RecyclerView.Adapter<TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(
            ItemTaskBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size
}
