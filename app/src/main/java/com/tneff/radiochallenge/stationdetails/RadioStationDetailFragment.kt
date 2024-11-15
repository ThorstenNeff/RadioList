package com.tneff.radiochallenge.stationdetails

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tneff.radiochallenge.R

class RadioStationDetailFragment : Fragment() {

    private val viewModel: RadioStationDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_radio_station_detail, container, false)
    }

    companion object {
        fun newInstance() = RadioStationDetailFragment()
    }
}