package com.example.foodshop.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodshop.R
import com.example.foodshop.databinding.FragmentDishesBinding
import com.example.foodshop.databinding.FragmentMainBinding
import com.example.foodshop.ui.adapter.DishesAdapter

class DishesFragment : Fragment() {

    val viewModel by lazy {
        ViewModelProvider(this)[DishesViewModel::class.java]
    }

    lateinit var adapter: DishesAdapter

    private var _binding: FragmentDishesBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentDishesBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDishesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {

        adapter = DishesAdapter()
        binding.dishesRecycler.adapter = adapter

        viewModel.dishesLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        binding.dishesRecycler.layoutManager = GridLayoutManager(requireActivity(), 3)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance() = DishesFragment()
    }
}