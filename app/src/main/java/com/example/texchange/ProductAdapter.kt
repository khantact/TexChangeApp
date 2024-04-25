package com.example.texchange

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val onClick: (ProductItem) -> Unit) :
    ListAdapter<ProductItem, ProductAdapter.ProductViewHolder>(ProductDiffCallback) {

    class ProductViewHolder(itemView: View, val onClick: (ProductItem) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val productTextView: TextView = itemView.findViewById(R.id.product_text)
        private val productImageView: ImageView = itemView.findViewById(R.id.product_image)
        private val productPriceView: TextView = itemView.findViewById(R.id.product_price)
        private var currentProduct: ProductItem? = null

        init {
            itemView.setOnClickListener {
                currentProduct?.let {
                    onClick(it)
                }
            }
        }

        fun bind(product: ProductItem) {
            currentProduct = product

            productTextView.text = product.name
            val price = "$" + product.price.toString()
            productPriceView.text = price
            if (product.image != null) {
                productImageView.setImageResource(product.image)
            } else {
                productImageView.setImageResource(R.drawable.ic_launcher_background)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)

    }
}

object ProductDiffCallback : DiffUtil.ItemCallback<ProductItem>() {
    override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
        return oldItem.id == newItem.id
    }
}