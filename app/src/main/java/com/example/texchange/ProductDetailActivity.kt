package com.example.texchange

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class ProductDetailActivity : AppCompatActivity() {

    private val productDetailViewModel by viewModels<ProductDetailViewModel> {
        ProductDetailViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_detail_activity)

        val productName: TextView = findViewById(R.id.product_detail_name)
        val productImage: ImageView = findViewById(R.id.product_detail_image)
        val productDescription: TextView = findViewById(R.id.product_detail_description)
        val removeProductButton: Button = findViewById(R.id.remove_button)

        val id : Long? = intent.extras?.getLong("itemID", -1)

        id?.let {
            val currentProduct = productDetailViewModel.getProductForId(it)
            productName.text = currentProduct?.name
            val price = "$" + currentProduct?.price.toString()
            productDescription.text = price

            if (currentProduct?.image == null) {
                productImage.setImageResource(R.drawable.ic_launcher_foreground)
            } else {
                productImage.setImageResource(currentProduct.image)
            }

            removeProductButton.setOnClickListener {
                if (currentProduct != null) {
                    productDetailViewModel.addToCart(currentProduct)
                }
                val intent = Intent(this@ProductDetailActivity, ProductListActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
}