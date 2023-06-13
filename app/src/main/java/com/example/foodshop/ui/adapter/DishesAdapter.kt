package com.example.foodshop.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.data.category.model.dishes.Dishe
import com.example.foodshop.databinding.DishesCardViewBinding

class DishesAdapter : ListAdapter<Dishe, DishesViewHolder>(DishesDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishesViewHolder {

        val binding = DishesCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DishesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DishesViewHolder, position: Int) {
        val item  = getItem(position)
        holder.bind(item)
    }
}