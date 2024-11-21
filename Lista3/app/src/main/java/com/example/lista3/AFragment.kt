package com.example.lista3

import WordListAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lista3.databinding.FragmentABinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AFragment : Fragment() {
    private val wordList by lazy { MutableList(50) { "word $it" } }
    private  lateinit var binding: FragmentABinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(layoutInflater)
        binding.recyclerView.apply {
            adapter = WordListAdapter(wordList){
                Toast.makeText(requireContext(), "Clicked + $it", Toast.LENGTH_SHORT).show()
            }
            layoutManager = LinearLayoutManager(requireContext())
        }
        return binding.root
    }
}