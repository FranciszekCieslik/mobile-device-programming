package com.example.a3list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a3list.data.DataProvider
import com.example.a3list.databinding.FragmentE2Binding

class FragmentE2 : Fragment() {

    private var _binding: FragmentE2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentE2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Przekazanie funkcji do adaptera
        val adapter = SubjectAdapter(DataProvider.subjects) { selectedSubject ->
            // Tutaj obsługujesz kliknięcie na przedmiot
            println("Wybrany przedmiot: ${selectedSubject.name}")
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

