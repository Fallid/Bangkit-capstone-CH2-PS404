package com.naufal.capstonech2ps404.model

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("Category")
	val category: Category? = null,

	@field:SerializedName("Description")
	val description: Description? = null,

	@field:SerializedName("Place_Name")
	val placeName: PlaceName? = null,

	@field:SerializedName("Price")
	val price: Price? = null,

	@field:SerializedName("Images")
	val images: Images? = null,

	@field:SerializedName("Rating")
	val rating: Rating? = null,

	@field:SerializedName("Long")
	val long: Long? = null,

	@field:SerializedName("City")
	val city: City? = null,

	@field:SerializedName("Lat")
	val lat: Lat? = null,

	@field:SerializedName("Hotel")
	val hotel: Hotel? = null
)

data class Category(

	@field:SerializedName("210")
	val jsonMember210: String? = null,

	@field:SerializedName("211")
	val jsonMember211: String? = null,

	@field:SerializedName("212")
	val jsonMember212: String? = null,

	@field:SerializedName("213")
	val jsonMember213: String? = null,

	@field:SerializedName("204")
	val jsonMember204: String? = null,

	@field:SerializedName("205")
	val jsonMember205: String? = null,

	@field:SerializedName("206")
	val jsonMember206: String? = null,

	@field:SerializedName("207")
	val jsonMember207: String? = null,

	@field:SerializedName("208")
	val jsonMember208: String? = null,

	@field:SerializedName("209")
	val jsonMember209: String? = null
)

data class PlaceName(

	@field:SerializedName("210")
	val jsonMember210: String? = null,

	@field:SerializedName("211")
	val jsonMember211: String? = null,

	@field:SerializedName("212")
	val jsonMember212: String? = null,

	@field:SerializedName("213")
	val jsonMember213: String? = null,

	@field:SerializedName("204")
	val jsonMember204: String? = null,

	@field:SerializedName("205")
	val jsonMember205: String? = null,

	@field:SerializedName("206")
	val jsonMember206: String? = null,

	@field:SerializedName("207")
	val jsonMember207: String? = null,

	@field:SerializedName("208")
	val jsonMember208: String? = null,

	@field:SerializedName("209")
	val jsonMember209: String? = null
)

data class Images(

	@field:SerializedName("210")
	val jsonMember210: String? = null,

	@field:SerializedName("211")
	val jsonMember211: String? = null,

	@field:SerializedName("212")
	val jsonMember212: String? = null,

	@field:SerializedName("213")
	val jsonMember213: String? = null,

	@field:SerializedName("204")
	val jsonMember204: String? = null,

	@field:SerializedName("205")
	val jsonMember205: String? = null,

	@field:SerializedName("206")
	val jsonMember206: String? = null,

	@field:SerializedName("207")
	val jsonMember207: String? = null,

	@field:SerializedName("208")
	val jsonMember208: String? = null,

	@field:SerializedName("209")
	val jsonMember209: String? = null
)

data class Hotel(

	@field:SerializedName("210")
	val jsonMember210: String? = null,

	@field:SerializedName("211")
	val jsonMember211: String? = null,

	@field:SerializedName("212")
	val jsonMember212: String? = null,

	@field:SerializedName("213")
	val jsonMember213: String? = null,

	@field:SerializedName("204")
	val jsonMember204: String? = null,

	@field:SerializedName("205")
	val jsonMember205: String? = null,

	@field:SerializedName("206")
	val jsonMember206: String? = null,

	@field:SerializedName("207")
	val jsonMember207: String? = null,

	@field:SerializedName("208")
	val jsonMember208: String? = null,

	@field:SerializedName("209")
	val jsonMember209: String? = null
)

data class Rating(

	@field:SerializedName("210")
	val jsonMember210: Int? = null,

	@field:SerializedName("211")
	val jsonMember211: Int? = null,

	@field:SerializedName("212")
	val jsonMember212: Int? = null,

	@field:SerializedName("213")
	val jsonMember213: Int? = null,

	@field:SerializedName("204")
	val jsonMember204: Int? = null,

	@field:SerializedName("205")
	val jsonMember205: Int? = null,

	@field:SerializedName("206")
	val jsonMember206: Int? = null,

	@field:SerializedName("207")
	val jsonMember207: Int? = null,

	@field:SerializedName("208")
	val jsonMember208: Int? = null,

	@field:SerializedName("209")
	val jsonMember209: Int? = null
)

data class City(

	@field:SerializedName("210")
	val jsonMember210: String? = null,

	@field:SerializedName("211")
	val jsonMember211: String? = null,

	@field:SerializedName("212")
	val jsonMember212: String? = null,

	@field:SerializedName("213")
	val jsonMember213: String? = null,

	@field:SerializedName("204")
	val jsonMember204: String? = null,

	@field:SerializedName("205")
	val jsonMember205: String? = null,

	@field:SerializedName("206")
	val jsonMember206: String? = null,

	@field:SerializedName("207")
	val jsonMember207: String? = null,

	@field:SerializedName("208")
	val jsonMember208: String? = null,

	@field:SerializedName("209")
	val jsonMember209: String? = null
)

data class Lat(

	@field:SerializedName("210")
	val jsonMember210: Any? = null,

	@field:SerializedName("211")
	val jsonMember211: Any? = null,

	@field:SerializedName("212")
	val jsonMember212: Any? = null,

	@field:SerializedName("213")
	val jsonMember213: Any? = null,

	@field:SerializedName("204")
	val jsonMember204: Any? = null,

	@field:SerializedName("205")
	val jsonMember205: Any? = null,

	@field:SerializedName("206")
	val jsonMember206: Any? = null,

	@field:SerializedName("207")
	val jsonMember207: Any? = null,

	@field:SerializedName("208")
	val jsonMember208: Any? = null,

	@field:SerializedName("209")
	val jsonMember209: Any? = null
)

data class Description(

	@field:SerializedName("210")
	val jsonMember210: String? = null,

	@field:SerializedName("211")
	val jsonMember211: String? = null,

	@field:SerializedName("212")
	val jsonMember212: String? = null,

	@field:SerializedName("213")
	val jsonMember213: String? = null,

	@field:SerializedName("204")
	val jsonMember204: String? = null,

	@field:SerializedName("205")
	val jsonMember205: String? = null,

	@field:SerializedName("206")
	val jsonMember206: String? = null,

	@field:SerializedName("207")
	val jsonMember207: String? = null,

	@field:SerializedName("208")
	val jsonMember208: String? = null,

	@field:SerializedName("209")
	val jsonMember209: String? = null
)

data class Long(

	@field:SerializedName("210")
	val jsonMember210: Any? = null,

	@field:SerializedName("211")
	val jsonMember211: Any? = null,

	@field:SerializedName("212")
	val jsonMember212: Any? = null,

	@field:SerializedName("213")
	val jsonMember213: Any? = null,

	@field:SerializedName("204")
	val jsonMember204: Any? = null,

	@field:SerializedName("205")
	val jsonMember205: Any? = null,

	@field:SerializedName("206")
	val jsonMember206: Any? = null,

	@field:SerializedName("207")
	val jsonMember207: Any? = null,

	@field:SerializedName("208")
	val jsonMember208: Any? = null,

	@field:SerializedName("209")
	val jsonMember209: Any? = null
)

data class Price(

	@field:SerializedName("210")
	val jsonMember210: Int? = null,

	@field:SerializedName("211")
	val jsonMember211: Int? = null,

	@field:SerializedName("212")
	val jsonMember212: Int? = null,

	@field:SerializedName("213")
	val jsonMember213: Int? = null,

	@field:SerializedName("204")
	val jsonMember204: Int? = null,

	@field:SerializedName("205")
	val jsonMember205: Int? = null,

	@field:SerializedName("206")
	val jsonMember206: Int? = null,

	@field:SerializedName("207")
	val jsonMember207: Int? = null,

	@field:SerializedName("208")
	val jsonMember208: Int? = null,

	@field:SerializedName("209")
	val jsonMember209: Int? = null
)
