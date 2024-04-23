package com.example.texchange

object Constants {

    private var appList = ArrayList<ProductItem>()
    private var shoppingCart = ArrayList<ProductItem>()

    fun getAppData():ArrayList<ProductItem> {
        val item1 = ProductItem(1,"Microwave", R.drawable.ic_launcher_foreground, 39.99)
        appList.add(item1)
        val item2 = ProductItem(2,"Coffee Maker", R.drawable.ic_launcher_foreground, 19.99)
        appList.add(item2)
        val item3 = ProductItem(3,"Jeans", R.drawable.ic_launcher_foreground, 19.99)
        appList.add(item3)
        val item4 = ProductItem(4,"Cutlery", R.drawable.ic_launcher_foreground, 19.99)
        appList.add(item4)
        val item5 = ProductItem(5,"Textbook", R.drawable.ic_launcher_foreground, 19.99)
        appList.add(item5)
        return appList
    }

    fun getAppInfo(idNum : Int) : ProductItem? {
        for (item in appList) {
            if (idNum == item.getProductIDNum()) {
                return item
            }
        }
        return null
    }

    fun getShoppingCart() : ArrayList<ProductItem>{
        return shoppingCart
    }

    fun addToCart(product : ProductItem) {
        shoppingCart.add(product)
    }

    fun resetCart() {
        shoppingCart = ArrayList<ProductItem>()
    }

}
