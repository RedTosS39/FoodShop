package com.example.data.category.model.location
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocationItem(
    val country: String,
    val lat: Double,
    val local_names: LocalNames,
    val lon: Double,
    val name: String
) : Parcelable