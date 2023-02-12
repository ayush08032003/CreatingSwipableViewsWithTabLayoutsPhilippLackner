package com.ayushwalker.creatingswipableviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(
    val images: List<Int>
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>(){ // Don't forget to call the constructor..
    inner class ViewPagerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) // This is extremely important

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager,parent,false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val curImage = images[position]
        holder.itemView.apply {
            val ivImage = findViewById<ImageView>(R.id.ivImage)
            ivImage.setImageResource(curImage)
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }
}