package com.tneff.radiochallenge.stationlist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.tneff.radiochallenge.R
import com.tneff.radiochallenge.databinding.ItemRadioStationBinding
import com.tneff.radiochallenge.stations.RadioStation


class RadioStationRecyclerViewAdapter(
    private var values: List<RadioStation> = listOf(),
    private val onClick: (item: RadioStation)->Unit,
) : RecyclerView.Adapter<RadioStationRecyclerViewAdapter.ViewHolder>() {

    fun submitList(newValues: List<RadioStation>) {
        values = newValues
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRadioStationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        val location = if (item.city.isNotEmpty()) {
            item.city
        } else if (item.country.isNotEmpty()) {
            item.country
        } else {
            ""
        }
        holder.imageView.load(item.url)
        holder.idView.text = location
        holder.contentView.text = item.name
        holder.itemView.setOnClickListener { onClick(item) }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: ItemRadioStationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.line1
        val contentView: TextView = binding.line2
        val imageView: ImageView = binding.radioLogo
        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}