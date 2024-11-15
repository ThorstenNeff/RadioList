package com.tneff.radiochallenge.stationdetails

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.tneff.radiochallenge.R
import com.tneff.radiochallenge.databinding.FragmentRadioStationDetailBinding
import com.tneff.radiochallenge.databinding.FragmentRadioStationListBinding
import com.tneff.radiochallenge.stations.RadioStation
import kotlinx.coroutines.launch

class RadioStationDetailFragment : Fragment() {
    private lateinit var binding: FragmentRadioStationDetailBinding
    val args: RadioStationDetailFragmentArgs by navArgs()
    private val viewModel: RadioStationDetailViewModel = RadioStationDetailViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.loadStation(args.stationId)
                viewModel.radioStation.collect { station ->
                    updateStation(station)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRadioStationDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun updateStation(station: RadioStation?) {
        binding.stationNameTv.text = station?.name ?: ""
    }
}