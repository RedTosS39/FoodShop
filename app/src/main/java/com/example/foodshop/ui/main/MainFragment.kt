package com.example.foodshop.ui.main

import android.Manifest
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.foodshop.databinding.FragmentMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationTokenSource
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainFragment : Fragment() {

    private lateinit var fLocation: FusedLocationProviderClient
    private lateinit var pLauncher: ActivityResultLauncher<String>

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
        getLocation()
        isPermissionGranted()
        observeViewModel()
        setupDateTime()
    }


    private fun getLocation() {
        fLocation = LocationServices.getFusedLocationProviderClient(requireContext())
        val cancelToken = CancellationTokenSource()

        if (ActivityCompat.checkSelfPermission(requireContext(),
                ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

        fLocation.getCurrentLocation(LocationRequest.PRIORITY_HIGH_ACCURACY, cancelToken.token)
            .addOnCompleteListener {
                lifecycleScope.launch {
                    viewModel.getParams(it.result.latitude, it.result.longitude)
                    Log.d("AAAA", "getLocation: ${it.result.latitude} ${ it.result.longitude}")
                }
            }
    }

    private fun isPermissionGranted() {
        if (!isPermissionGrated(ACCESS_FINE_LOCATION)) {
            permissionListener()
            pLauncher.launch(ACCESS_FINE_LOCATION)
        }
    }

    private fun permissionListener() {
        pLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            Toast.makeText(requireActivity().applicationContext,
                "Permission: $it",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun observeViewModel() {
        viewModel.cityLabel.observe(viewLifecycleOwner) {
            binding.tvCityLabel.text = it.get(0).name
        }
    }

    private fun setupDateTime() {
        val formatter = SimpleDateFormat(DATE_PATTERN)
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
        private const val DATE_PATTERN = "dd MMMM, yyyy"
    }
}
