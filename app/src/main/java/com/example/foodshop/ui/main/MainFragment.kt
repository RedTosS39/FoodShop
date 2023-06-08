package com.example.foodshop.ui.main

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.foodshop.MainActivity
import com.example.foodshop.R
import com.example.foodshop.databinding.FragmentMainBinding
import com.example.foodshop.databinding.ScreenOneCardViewBinding
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("FragmentMainBinding == null")



    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        observeViewModel()
        setupDateTime()
    }

    private fun observeViewModel() {
        viewModel.cityLabel.observe(viewLifecycleOwner) {
            binding.tvCityLabel.text = it
        }
    }

    private fun setupDateTime() {
        val formatter = SimpleDateFormat("dd MMMM, yyyy")
        val date = Date()
        val current = formatter.format(date)

        binding.tvDateTime.text = current

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance() = MainFragment()

    }
}
