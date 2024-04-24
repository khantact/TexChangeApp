package com.example.texchange

object Constants {

    private var appList = ArrayList<ProductItem>()
    init {
        val item1 = ProductItem(1,"Microwave", R.drawable.microwave, 55.49)
        appList.add(item1)
        val item2 = ProductItem(2,"Textbook", R.drawable.textbook, 19.99)
        appList.add(item2)
        val item3 = ProductItem(3,"Coffee Machine", R.drawable.coffee_machine, 75.89)
        appList.add(item3)
        val item4 = ProductItem(4,"Cutlery", R.drawable.test3, 40.55)
        appList.add(item4)
        val item5 = ProductItem(5,"Jeans", R.drawable.jeans, 10.99)
        appList.add(item5)
    }

    fun getAppData():ArrayList<ProductItem> {
        return appList
    }

    fun getProductInfo(idNum : Long) : ProductItem? {
        for (item in appList) {
            if (idNum == item.id) {
                return item
            }
        }
        return null
    }

}
