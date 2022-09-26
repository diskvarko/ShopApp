package com.example.shopapp.ui.data.model

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView

data class ItemCategoryModel(
    val image: Drawable,
    val category: String,
    val isSelected: Boolean
)