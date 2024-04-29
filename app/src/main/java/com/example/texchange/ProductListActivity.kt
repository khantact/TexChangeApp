package com.example.texchange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView

const val PRODUCT_ID = "itemID"
class ProductListActivity : AppCompatActivity() {

    private val shoppingCartViewModel by viewModels<ShoppingCartViewModel> {
        ShoppingCartViewModelFactory(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_list)

        val productAdapter = ProductAdapter { product -> adapterOnClick(product) }

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = productAdapter

        shoppingCartViewModel.productLiveData.observe(this) {
            it?.let {
                productAdapter.submitList(it as MutableList<ProductItem>)
            }
        }

        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener {
            fabOnClick()
        }

    }

    private fun adapterOnClick(product: ProductItem) {
        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra(PRODUCT_ID, product.id)
        startActivity(intent)
    }

    private fun fabOnClick() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}