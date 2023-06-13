package com.example.foodshop.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.data.category.model.dishes.Dishe
import com.example.foodshop.databinding.DishesCardViewBinding
import com.squareup.picasso.Picasso

class DishesViewHolder(private val binding: DishesCardViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(dish: Dishe) {
        Picasso.get().load(dish.image_url).into(binding.imageView2)
        binding.dishLabel.text = dish.name
    }
}