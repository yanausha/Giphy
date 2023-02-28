package com.example.giphy.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.giphy.databinding.GifItemBinding
import com.example.giphy.domain.entity.Gif

class GifListAdapter : ListAdapter<Gif, GifViewHolder>(GifDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        val binding = GifItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GifViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        val gifInfo = getItem(position)
        Glide.with(holder.itemView).load(gifInfo.imageUrl).into(holder.binding.imageViewGif)
    }
}

class GifViewHolder(
    val binding: GifItemBinding
) : ViewHolder(binding.root)