package com.example.a3list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a3list.databinding.ItemTaskListBinding
import com.example.a3list.holder.TaskListViewHolder

class TaskListAdapter(
    private val tasks: List<ExerciseList>,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<TaskListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        return TaskListViewHolder(
            ItemTaskListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )){onItemClick(it)}
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size
}