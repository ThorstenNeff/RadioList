package com.tneff.radiochallenge.stationlist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tneff.radiochallenge.R

import com.tneff.radiochallenge.stationlist.placeholder.PlaceholderContent.PlaceholderItem
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
        holder.idView.text = item.id
        holder.contentView.text = item.name
        holder.itemView.setOnClickListener { onClick(item) }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: ItemRadioStationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}