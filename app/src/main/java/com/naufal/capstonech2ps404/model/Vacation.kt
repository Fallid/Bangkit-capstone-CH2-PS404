package com.naufal.capstonech2ps404.model

data class Vacation(
    val id:String,
    val name: String,
    val description:String,
    val photoUrl: String,
    val rating: String,
    val price: String,
    val duration: String,
    val kota: String,
    var isListed: Boolean = false,
)

