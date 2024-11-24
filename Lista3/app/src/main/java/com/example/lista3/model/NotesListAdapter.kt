package com.example.lista3.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lista3.databinding.NotesListItemBinding

class NotesListAdapter(
    private val wordList: MutableList<String>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<NotesListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesListViewHolder {
        return NotesListViewHolder(
            NotesListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        ){onItemClick(wordList[it])}
    }

    override fun getItemCount(): Int = wordList.size

    override fun onBindViewHolder(holder: NotesListViewHolder, position: Int) {
//        val currentItem = wordList[position]
        holder.bind()
    }

}