package com.example.texchange

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProductDetailViewModel(private val datasource: DataSource) : ViewModel() {

    fun getProductForId(id: Long) : ProductItem? {
        return datasource.getProductForId(id)
    }

    fun removeProduct(product: ProductItem) {
        datasource.removeProduct(product)
    }

    fun addToCart(product: ProductItem) : Boolean {
        if (datasource.checkCartForProduct(product.id) == null) {
            datasource.addToCart(product)
            return true
        }
        return false
    }
}

class ProductDetailViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProductDetailViewModel(
                datasource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}