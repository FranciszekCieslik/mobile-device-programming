package com.example.a3list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a3list.data.DataProvider
import com.example.a3list.databinding.FragmentE1Binding

class FragmentE1 : Fragment() {

    private var _binding: FragmentE1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentE1Binding.inflate(inflater, container, false)
        binding.recyclerView.apply {
            val taskList = DataProvider.subjects.flatMap { it.exercises }
            adapter = TaskListAdapter(
                tasks = taskList
            ){}
            layoutManager = LinearLayoutManager(requireContext())
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val exercises = DataProvider.subjects.flatMap { it.exercises }

        // Adapter with click listener
        val adapter = TaskListAdapter(exercises) { selectedTask ->
            println("Selected task: ${exercises[selectedTask].subject}:${exercises[selectedTask].name}")

//            val navController = findNavController()
//            // Navigate to fragment_e3
//            navController.navigate(action_fragmentE1_to_fragmentE3)

            // Przejście do fragmentE3 z nawigacją
            val navController = findNavController()
            val action = FragmentE1Directions.actionFragmentE1ToFragmentE3(selectedTask)
            navController.navigate(action)

        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}