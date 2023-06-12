package com.example.data.category.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryList(
    val categories: List<Category>
) : Parcelable