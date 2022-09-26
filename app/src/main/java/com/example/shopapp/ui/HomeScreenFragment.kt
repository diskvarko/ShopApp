package com.example.shopapp.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.shopapp.R
import com.example.shopapp.data.CategoryMock
import com.example.shopapp.ui.data.ItemProductModel
import com.example.shopapp.ui.data.model.ItemCategoryModel
import com.example.shopapp.ui.ui.login.ItemCategoryAdapter
import com.example.shopapp.ui.ui.login.ItemProductAdapter

class HomeScreenFragment : Fragment() {

    companion object {
        fun newInstance() = HomeScreenFragment()
    }

    private val viewModel: HomeScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_screen_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerHomeItems)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, 1)
        recyclerView.adapter = context?.let { fillList(it) }?.let { ItemProductAdapter(it) }

        val recyclerViewCategory: RecyclerView = view.findViewById(R.id.recyclerHomeCategory)
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerViewCategory.layoutManager = layoutManager
        recyclerViewCategory.adapter = context?.let { CategoryMock.getMockCategory(it) }?.let {
            ItemCategoryAdapter(it) { itemCategoryModel ->
                viewModel.setSelectedCategory(itemCategoryModel)
                Toast.makeText(requireContext(), "qwer", Toast.LENGTH_LONG).show()
            }
        }
        viewModel.isCategorySelected.observe(viewLifecycleOwner) {

        }

    }


    private fun fillList(context: Context): List<ItemProductModel> {
        val data = mutableListOf<ItemProductModel>()
        (0..10).forEach { _ ->
            data.add(
                ItemProductModel(
                    context.getDrawable(R.drawable.electro1)!!,
                    "ShopHame",
                    "ProductName",
                    "1234$",
                    "4.5"
                )
            )
        }
        return data
    }

    private fun fillListCategory(context: Context): List<ItemCategoryModel> {
        val data = mutableListOf<ItemCategoryModel>()
        data.add(
            ItemCategoryModel(
                context.getDrawable(R.drawable.img_product_test)!!,
                "ShopHame",
                true

            )
        )
        (0..10).forEach { _ ->
            data.add(
                ItemCategoryModel(
                    context.getDrawable(R.drawable.img_product_test)!!,
                    "ShopHame",
                    false

                )
            )
        }
        return data
    }


}