package com.example.foodshop.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.data.category.model.categories.Category
import com.example.data.category.model.dishes.Dishe

object DishesDiffCallback : DiffUtil.ItemCallback<Dishe>() {
    override fun areItemsTheSame(oldItem: Dishe, newItem: Dishe): Boolean {
       return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Dishe, newItem: Dishe): Boolean {
        return oldItem == newItem
    }
}