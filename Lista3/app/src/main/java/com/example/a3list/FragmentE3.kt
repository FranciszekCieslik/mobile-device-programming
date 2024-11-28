package com.example.a3list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a3list.data.DataProvider
import com.example.a3list.databinding.FragmentE3Binding

class FragmentE3 : Fragment() {

    private var _binding: FragmentE3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentE3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = binding.toolbar
        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_24) // Replace with your back icon resource
        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp() // Navigate back to the previous fragment
        }

        // Odbierz argument za pomocą FragmentArgs
        val selectedTaskIndex = FragmentE3Args.fromBundle(requireArguments()).selectedTask
        if (selectedTaskIndex != -1) {
            val selectedTask = DataProvider.subjects.flatMap { it.exercises }[selectedTaskIndex]
            println("Odebrane zadanie: ${selectedTask.name}")
            binding.subjectName.text = selectedTask.subject
            binding.listName.text = selectedTask.name

            val exercises = selectedTask.exercises
            val adapter = TaskAdapter(exercises) {}
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                this.adapter = adapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
