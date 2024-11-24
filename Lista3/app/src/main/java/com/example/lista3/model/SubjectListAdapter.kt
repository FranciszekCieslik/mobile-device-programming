package com.example.lista3.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lista3.databinding.ItemSubjectListBinding

class SubjectListAdapter (
    private val wordList: MutableList<String>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<SubjectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        return SubjectViewHolder(
            ItemSubjectListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        ){onItemClick(wordList[it])}
    }

    override fun getItemCount(): Int = wordList.size

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        holder.bind()
    }

}