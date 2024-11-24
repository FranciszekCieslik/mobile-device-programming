package com.example.lista3.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lista3.databinding.TasksListItemBinding

class TasksListAdapter(
    private val wordList: MutableList<String>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<TasksListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksListViewHolder {
        return TasksListViewHolder(
            TasksListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        ){onItemClick(wordList[it])}
    }

    override fun getItemCount(): Int = wordList.size

    override fun onBindViewHolder(holder: TasksListViewHolder, position: Int) {
        holder.bind()
    }

}