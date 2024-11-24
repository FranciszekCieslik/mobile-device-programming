package com.example.lista3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lista3.model.SubjectListAdapter
import com.example.lista3.databinding.FragmentABinding

class AFragment : Fragment() {
    private val wordList by lazy {MutableList(50){"$it"}}
    private  lateinit var binding: FragmentABinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(layoutInflater)
        binding.recyclerView.apply {
            adapter = SubjectListAdapter(wordList){}
            layoutManager = LinearLayoutManager(requireContext())
        }
        return binding.root
    }
}