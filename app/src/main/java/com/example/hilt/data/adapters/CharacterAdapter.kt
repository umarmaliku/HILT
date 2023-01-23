package com.example.hilt.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.hilt.data.PhotoModel
import com.example.hilt.databinding.ItemPhotoBinding

class CharacterAdapter:
    ListAdapter<PhotoModel, CharacterAdapter.CharactersViewHolder>(diffUtil) {

    inner class CharactersViewHolder(private val binding: ItemPhotoBinding) :

        ViewHolder(binding.root) {
        fun onBind(item: PhotoModel) {
            Glide.with(binding.imCherepters.context)
                .load(item.url)
                .into(binding.imCherepters)
            binding.tvTitle.text = item.title.replaceFirstChar {
                it.uppercase()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(
            ItemPhotoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<PhotoModel>() {
            override fun areItemsTheSame(
                oldItem: PhotoModel,
                newItem: PhotoModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: PhotoModel,
                newItem: PhotoModel
            ): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }
}