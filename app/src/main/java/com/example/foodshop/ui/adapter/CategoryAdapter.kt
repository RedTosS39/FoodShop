package com.example.foodshop.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.data.category.model.Category
import com.example.foodshop.databinding.ScreenOneCardViewBinding
import com.squareup.picasso.Picasso

class CategoryAdapter : ListAdapter<Category, ItemViewHolder>(ItemDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            ScreenOneCardViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        val binding = holder.binding

        with(binding) {
            categoryLabel.text = item.name.toString()
            Picasso.get().load(item.image_url).into(materialButton)
        }
    }
}
