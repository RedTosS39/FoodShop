package com.example.data.category.model.dishes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Dishes(
    val dishes: List<Dishe>
) : Parcelable