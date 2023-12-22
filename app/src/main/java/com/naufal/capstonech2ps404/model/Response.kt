package com.naufal.capstonech2ps404.model

import com.google.gson.annotations.SerializedName

data class ResponseItem(

	@field:SerializedName("place_name")
	val placeName: String? = null,

	@field:SerializedName("images")
	val images: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("latitude")
	val latitude: Any? = null,

	@field:SerializedName("rating")
	val rating: Double? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("hotel")
	val hotel: String? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("longitude")
	val longitude: Any? = null
)
