package com.tneff.radiochallenge.stationlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tneff.radiochallenge.databinding.FragmentRadioStationListBinding
import com.tneff.radiochallenge.stations.RadioStation
import kotlinx.coroutines.launch

/**
 * A fragment representing a list of Items.
 */
class RadioStationListFragment : Fragment() {

    private lateinit var binding: FragmentRadioStationListBinding
    private lateinit var adapter: RadioStationRecyclerViewAdapter

    // TODO: Use ViewModelProvider / Factory
    private val viewModel: RadioStationListViewModel = RadioStationListViewModel()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.radioStations.collect { stations ->
                    adapter.submitList(stations)
                }
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRadioStationListBinding.inflate(inflater, container, false)
        adapter = RadioStationRecyclerViewAdapter(listOf()) { station: RadioStation ->
            showStation(station)
        }
        binding.stationRV.adapter = adapter
        binding.stationRV.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }

    private fun showStation(station: RadioStation) {
        findNavController().navigate(RadioStationListFragmentDirections.actionToDetail(station.id))
    }
}
