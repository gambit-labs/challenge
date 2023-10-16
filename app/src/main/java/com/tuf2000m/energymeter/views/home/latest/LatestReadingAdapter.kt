package com.tuf2000m.energymeter.views.home.latest

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tuf2000m.energymeter.data.model.meterdata.Data
import com.tuf2000m.energymeter.databinding.ItemEnergycellBinding
import com.tuf2000m.energymeter.views.home.recenthistory.OnItemClickListener


/**
 * Adapter for the home screen RecyclerView displaying energy data.
 *
 * @param items List of energy data to be displayed.
 * @param listener Item click listener.
 */
class LatestReadingAdapter(
    private var items: List<Data>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<LatestReadingAdapter.ViewHolder>() {

    /**
     * ViewHolder for the energy data item view.
     *
     * @param viewHolder Item's binding.
     */
    class ViewHolder(val viewHolder: ItemEnergycellBinding) :
        RecyclerView.ViewHolder(viewHolder.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the item layout and create a ViewHolder for it
        val binding =
            ItemEnergycellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind data to the item view
        val item = items[position]
        holder.viewHolder.tvVariable.text = item.variableName
        holder.viewHolder.tvVariablevalue.text = item.value.toString()
        holder.viewHolder.tvVariablcategory.text = item.category
        holder.viewHolder.tvVariableunit.text = item.unit
        // Notify the click listener about item click
        listener.onItemClick(position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setContentData(data: List<Data>) {
        items = data
        Log.d("TAG", "set content DataSize: ${items.size}")
        notifyDataSetChanged()
    }
}
