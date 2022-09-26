package com.example.shopapp.ui.ui.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.shopapp.R
import com.example.shopapp.ui.data.model.ItemCategoryModel
import com.google.android.material.card.MaterialCardView

class ItemCategoryAdapter(
    private val items: List<ItemCategoryModel>,
    val onClickListener: (ItemCategoryModel) -> Unit
) :
    RecyclerView.Adapter<ItemCategoryAdapter.CategoryItemViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CategoryItemViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_category, viewGroup, false)

        return CategoryItemViewHolder(view) {
            onClickListener(items[it])
        }
    }

    override fun onBindViewHolder(viewHolder: CategoryItemViewHolder, position: Int) {
        viewHolder.bind(items[position])
    }

    class CategoryItemViewHolder(itemView: View, clickAtPosition: (Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageViewCategory)
        private val categoryName: TextView = itemView.findViewById(R.id.categoryName)
        private val cardView: MaterialCardView = itemView.findViewById(R.id.card_view)

        init {
            itemView.setOnClickListener {
                clickAtPosition(adapterPosition)
            }
        }

        fun bind(item: ItemCategoryModel) {
            itemView.apply {
                imageView.load(item.image)
                categoryName.text = item.category
                if (item.isSelected) {
                    cardView.strokeColor = resources.getColor(R.color.pink_main)
                    cardView.strokeWidth = 2
                }

            }
        }
    }

    override fun getItemCount() = items.size

}