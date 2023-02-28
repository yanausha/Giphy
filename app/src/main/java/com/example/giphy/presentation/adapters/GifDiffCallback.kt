package com.example.giphy.presentation.adapters

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.example.giphy.domain.entity.Gif

object GifDiffCallback : ItemCallback<Gif>() {

    override fun areItemsTheSame(oldItem: Gif, newItem: Gif): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Gif, newItem: Gif): Boolean {
        return oldItem == newItem
    }
}