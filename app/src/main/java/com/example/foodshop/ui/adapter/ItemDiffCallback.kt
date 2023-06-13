package com.example.foodshop.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.data.category.model.categories.Category

object ItemDiffCallback : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
       return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}