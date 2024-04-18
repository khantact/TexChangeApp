package com.example.texchange

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ProductItemDetails : Activity() {

    private lateinit var imgView : ImageView
    private lateinit var txtView : TextView
    private lateinit var detailView : TextView

    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details)

        val id = intent.getIntExtra("itemID", -1)

        val product = Constants.getAppInfo(id)

        if (product != null) {
            imgView = findViewById(R.id.img)
            txtView = findViewById(R.id.title)
            detailView = findViewById(R.id.details)

            imgView.setImageResource(product.getProductPic())
            txtView.text = product.getProductName()
            val price = "$" + product.getProductPrice().toString()
            detailView.text = price

            button = findViewById(R.id.add)
            button.setOnClickListener{
                Constants.addToCart(product)
                //val intent = Intent(this@ProductItemDetails, CheckoutActivity::class.java)
                startActivity(intent)
            }

        }

    }


}