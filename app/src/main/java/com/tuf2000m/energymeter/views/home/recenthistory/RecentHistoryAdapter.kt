package com.tuf2000m.energymeter.views.home.recenthistory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tuf2000m.energymeter.data.model.recent.RecentData
import com.tuf2000m.energymeter.databinding.ItemRecyclerRecentsBinding

interface OnItemClickListener {
    fun onItemClick(
        position: Int
    )
}

class RecentAdapter(
    private val items: List<RecentData.RecentList>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<RecentAdapter.ViewHolder>() {

    class ViewHolder(val viewHolder: ItemRecyclerRecentsBinding) :
        RecyclerView.ViewHolder(viewHolder.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRecyclerRecentsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        listener.onItemClick(position)
        holder.viewHolder.tvRecent.text = items[position].timeStamp


    }


    override fun getItemCount(): Int {
        return items.size
    }
}