package com.example.lista3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lista3.databinding.FragmentBBinding
import com.example.lista3.databinding.FragmentCBinding
import com.example.lista3.model.NotesListAdapter
import com.example.lista3.model.SubjectListAdapter

class CFragment: Fragment() {
    private val wordList by lazy {MutableList(50){"$it"}}
    private  lateinit var binding: FragmentCBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCBinding.inflate(layoutInflater)
        binding.recyclerView.apply {
            adapter = SubjectListAdapter(wordList){}
            layoutManager = LinearLayoutManager(requireContext())
        }
        return binding.root
    }
}