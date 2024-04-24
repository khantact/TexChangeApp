package com.example.texchange

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.random.Random

class ShoppingCartViewModel(val dataSource: DataSource) : ViewModel() {

    val productLiveData = dataSource.getShoppingCart()

    fun insertProduct(productName: String?, price: Double?) {
        if (productName == null || price == null) {
            return
        }

        val image = dataSource.getRandomProductImageAsset()
        val newProduct = ProductItem(
            Random.nextLong(),
            productName,
            image,
            price
        )

        dataSource.addToCart(newProduct)
    }
}

class ShoppingCartViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoppingCartViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ShoppingCartViewModel(
                dataSource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}