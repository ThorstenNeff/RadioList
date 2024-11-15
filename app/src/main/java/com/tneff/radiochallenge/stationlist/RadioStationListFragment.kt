package com.tneff.radiochallenge.stationlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.tneff.radiochallenge.R
import com.tneff.radiochallenge.databinding.FragmentRadioStationListBinding
import com.tneff.radiochallenge.stationlist.placeholder.PlaceholderContent
import kotlinx.coroutines.launch

/**
 * A fragment representing a list of Items.
 */
class RadioStationListFragment : Fragment() {

    private val viewModel: RadioStationListViewModel by viewModels()
    private lateinit var binding: FragmentRadioStationListBinding
    private lateinit var adapter: RadioStationRecyclerViewAdapter

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
        adapter = RadioStationRecyclerViewAdapter(listOf()) {

        }
        binding.stationRV.adapter = adapter
        binding.stationRV.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }
}
