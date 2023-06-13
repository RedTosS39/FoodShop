package com.example.data.category.model.categories

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryList(
    val сategories: List<Category>
) : Parcelable