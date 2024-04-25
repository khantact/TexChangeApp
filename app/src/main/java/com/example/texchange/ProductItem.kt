package com.example.texchange

import androidx.annotation.DrawableRes

data class ProductItem(
    val id: Long,
    val name: String,
    @DrawableRes
    val image: Int?,
    val price: Double
)