package com.example.texchange

import android.content.res.Resources

fun productList(resources: Resources): List<ProductItem> {

    val one = resources.getString(R.string.price).toDouble()
    val two = resources.getString(R.string.price2).toDouble()
    val three = resources.getString(R.string.price3).toDouble()
    val four = resources.getString(R.string.price4).toDouble()
    val five = resources.getString(R.string.price5).toDouble()


    return listOf(
        ProductItem(
            id = 1,
            name = resources.getString(R.string.one),
            image = R.drawable.microwave,
            price = one
        ),
        ProductItem(
            id = 2,
            name = resources.getString(R.string.two),
            image = R.drawable.textbook,
            price = two
        ),
        ProductItem(
            id = 3,
            name = resources.getString(R.string.three),
            image = R.drawable.coffee_machine,
            price = three
        ),
        ProductItem(
            id = 4,
            name = resources.getString(R.string.four),
            image = R.drawable.test3,
            price = four
        ),
        ProductItem(
            id = 5,
            name = resources.getString(R.string.five),
            image = R.drawable.jeans,
            price = five
        )
    )
}