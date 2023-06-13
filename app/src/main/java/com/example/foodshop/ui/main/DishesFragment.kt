package com.example.foodshop.ui.main

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodshop.databinding.FragmentDishesBinding
import com.example.foodshop.ui.adapter.DishesAdapter


class DishesFragment : Fragment() {

    private val viewModel by lazy {
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
        setupToolbar()
        setupAdapter()

    }

    private fun setupToolbar() {
        binding.toolbarLabel.text =  arguments?.getString(ARGS_KEY, ERROR_ARGS)
        binding.toolbar.setNavigationOnClickListener { requireActivity().onBackPressed() }
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

        private const val ARGS_KEY = "DishesFragment_ARGS_KEY"
        private const val ERROR_ARGS = "No args"

        fun newInstance(dishLabel: String): DishesFragment {
            return DishesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARGS_KEY, dishLabel)
                }
            }
        }
    }
}