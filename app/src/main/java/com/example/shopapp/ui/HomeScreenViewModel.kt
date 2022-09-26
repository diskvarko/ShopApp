package com.example.shopapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopapp.ui.data.model.ItemCategoryModel

class HomeScreenViewModel : ViewModel() {
    private val _isCategorySelected = MutableLiveData<ItemCategoryModel>()
    val isCategorySelected: LiveData<ItemCategoryModel> = _isCategorySelected

    fun setSelectedCategory(item: ItemCategoryModel) {
        _isCategorySelected.value = item
    }
}