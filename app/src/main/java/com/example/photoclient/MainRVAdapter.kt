package com.example.photoclient

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.photoclient.data.PhotoData
import com.example.photoclient.data.PhotoDataList

class MainRVAdapter() : RecyclerView.Adapter<MainRVAdapter.ViewHolder>() {
    private var list = PhotoDataList.getList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img = itemView.findViewById<ImageView>(R.id.imageView)
        fun bind(photoData: PhotoData) {
            img.setImageResource(photoData.photo)
        }
    }
}