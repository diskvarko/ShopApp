package com.example.shopapp.ui.data

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView

data class ItemProductModel(
    val image: Drawable,
    val shopName: String,
    val productName: String,
    val price: String,
    val rating: String
)