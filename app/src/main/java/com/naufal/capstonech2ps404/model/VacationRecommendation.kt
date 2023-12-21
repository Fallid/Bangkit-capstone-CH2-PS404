package com.naufal.capstonech2ps404.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class VacationRecommendation(
    @field:SerializedName("Place_Name")
    val placeName: String,

    @field:SerializedName("City")
    val city: String,

    @field:SerializedName("Images")
    val images: String,

    @field:SerializedName("Price")
    val price: Double,

    @field:SerializedName("Rating")
    val rating: Double,

    @field:SerializedName("Lat")
    val lat: Double,

    @field:SerializedName("Long")
    val long: Double,

    @field:SerializedName("Category")
    val category: String,

    @field:SerializedName("Description")
    val description: String,

    @field:SerializedName("Hotel")
    val hotel: String,

    @field:SerializedName("abs_diff")
    val absDiff: Double
):Parcelable