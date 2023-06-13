package com.example.data.category.model.categories

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val id: Int,
    val image_url: String,
    val name: String
) : Parcelable