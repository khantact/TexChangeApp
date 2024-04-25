package com.example.texchange

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataSource(resources: Resources) {
    private val initialProductList = productList(resources)
    private val productLiveData = MutableLiveData(initialProductList)
    private val shoppingCartLiveData = MutableLiveData<List<ProductItem>>()

    fun addProduct(product: ProductItem) {
        val currentList = productLiveData.value
        if (currentList == null) {
            productLiveData.postValue(listOf(product))
        } else {
            val updatedList = currentList.toMutableList()
            updatedList.add(0, product)
            productLiveData.postValue(updatedList)
        }
    }

    fun addToCart(product: ProductItem) {
        val currentList = shoppingCartLiveData.value
        if (currentList == null) {
            shoppingCartLiveData.postValue(listOf(product))
        } else {
            val updatedList = currentList.toMutableList()
            updatedList.add(0, product)
            shoppingCartLiveData.postValue(updatedList)
        }
    }

    fun removeProduct(product: ProductItem) {
        val currentList = productLiveData.value
        if (currentList != null) {
            val updatedList = currentList.toMutableList()
            updatedList.remove(product)
            productLiveData.postValue(updatedList)
        }
    }

    fun getProductForId(id: Long): ProductItem? {
        productLiveData.value?.let { products ->
            return products.firstOrNull{ it.id == id}
        }
        return null
    }

    fun getProductList(): LiveData<List<ProductItem>> {
        return productLiveData
    }

    fun getShoppingCart(): LiveData<List<ProductItem>> {
        return shoppingCartLiveData
    }

    fun getRandomProductImageAsset(): Int? {
        val randomNumber = (initialProductList.indices).random()
        return initialProductList[randomNumber].image
    }

    companion object {
        private var INSTANCE: DataSource? = null

        fun getDataSource(resources: Resources): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}