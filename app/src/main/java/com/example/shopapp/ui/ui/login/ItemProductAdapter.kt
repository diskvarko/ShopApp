package com.example.shopapp.ui.ui.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.shopapp.R
import com.example.shopapp.ui.data.ItemProductModel

class ItemProductAdapter(private val items: List<ItemProductModel>) :
    RecyclerView.Adapter<ItemProductAdapter.ProductItemViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ProductItemViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_product, viewGroup, false)

        return ProductItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ProductItemViewHolder, position: Int) {
        viewHolder.bind(items[position])
    }

    class ProductItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val shopNameTv: TextView = itemView.findViewById(R.id.shopNameTv)
        private val productNameTv: TextView = itemView.findViewById(R.id.productNameTv)
        private val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)

        fun bind(item: ItemProductModel) {
            itemView.apply {
                imageView.load(item.image)
                shopNameTv.text = item.shopName
                productNameTv.text = item.productName
                priceTextView.text = item.price
            }
        }
    }

    override fun getItemCount() = items.size

}