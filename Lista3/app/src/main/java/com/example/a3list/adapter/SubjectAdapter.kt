package com.example.a3list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.a3list.databinding.ItemSubjectBinding
import com.example.a3list.holder.SubjectViewHolder

class SubjectAdapter(
    private val subjects: List<Subject>,
    private val onSubjectClick: (Subject) -> Unit // Callback na kliknięcie przedmiotu
) : RecyclerView.Adapter<SubjectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_subject, parent, false)
        return SubjectViewHolder(ItemSubjectBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        holder.bind(subjects[position])
    }

    override fun getItemCount(): Int = subjects.size
}
