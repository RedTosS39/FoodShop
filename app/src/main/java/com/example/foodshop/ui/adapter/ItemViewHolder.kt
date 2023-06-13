package com.example.foodshop.ui.adapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.data.category.model.categories.Category
import com.example.foodshop.databinding.ScreenOneCardViewBinding
import com.squareup.picasso.Picasso

class ItemViewHolder(private val binding: ScreenOneCardViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(category: Category) {
        with(binding) {
            categoryLabel.text = category.name
            Log.d("AAAA", "bind:  ${category.name}")
            Picasso.get().load(category.image_url).into(materialButton)
        }
    }
}