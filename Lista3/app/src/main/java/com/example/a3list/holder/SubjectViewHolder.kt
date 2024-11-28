package com.example.a3list.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.a3list.Subject
import com.example.a3list.databinding.ItemSubjectBinding
import kotlin.math.round

class SubjectViewHolder(
    private val binding: ItemSubjectBinding
    ) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.setOnClickListener {
            //onItemClick(adapterPosition)
        }
    }
        fun bind(subject: Subject) {
            binding.textSubjectName.text = subject.name
            val grades = subject.grades
            val average =
                round(grades.sum()/grades.size*100) /100
            binding.textSubjectAverage.text = "Średnia: ${average}"

            //itemView.setOnClickListener { onSubjectClick(subject) }
        }
}