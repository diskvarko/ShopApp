package com.example.shopapp.data

import android.content.Context
import com.example.shopapp.R
import com.example.shopapp.ui.data.model.ItemCategoryModel

object CategoryMock {

    fun getMockCategory(context: Context): List<ItemCategoryModel> {
        val result = listOf<ItemCategoryModel>(
            ItemCategoryModel(
                context.getDrawable(R.drawable.category_1)!!,
                "ShopHame",
                true

            ),
            ItemCategoryModel(
                context.getDrawable(R.drawable.category_2)!!,
                "ShopHame",
                false

            ),
            ItemCategoryModel(
                context.getDrawable(R.drawable.category_3)!!,
                "ShopHame",
                false

            ),
            ItemCategoryModel(
                context.getDrawable(R.drawable.category_4)!!,
                "ShopHame",
                false

            ),
            ItemCategoryModel(
                context.getDrawable(R.drawable.category_6)!!,
                "ShopHame",
                false

            )
        )
        return result
    }
}