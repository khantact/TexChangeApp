package com.example.texchange

class ProductItem (private var productIDNum : Int, private var productName: String, private var productPic: Int, private var productPrice: Double) {

    fun getProductIDNum(): Int {
        return productIDNum
    }

    fun setProductIDNum(productIDNum: Int) {
        this.productIDNum = productIDNum
    }

    fun getProductName(): String {
        return productName
    }

    fun setProductName(productName: String) {
        this.productName = productName
    }

    fun getProductPic(): Int {
        return productPic
    }

    fun setProductPic(productPic: Int) {
        this.productPic = productPic
    }

    fun getProductPrice(): Double {
        return productPrice
    }

    fun setProductName(productPrice : Double) {
        this.productPrice = productPrice
    }

    fun isEqual(otherApp : ProductItem): Boolean {
        return this.productIDNum == otherApp.productIDNum
    }
}