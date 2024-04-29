package com.example.texchange

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    companion object {
        const val TAG = "HomeActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)

        val searchButton = findViewById<Button>(R.id.search_button)
        val searchText = findViewById<EditText>(R.id.search_input)
        val resultsTextView = findViewById<TextView>(R.id.search_results)  // Get the TextView reference

        val appRecycleView = findViewById<RecyclerView>(R.id.recycle)

        val appArrayList = Constants.getAppData()
        val appAdapter = AppAdapter(this, appArrayList)
        val gridLayoutManager = GridLayoutManager(this, 2)

        appRecycleView.layoutManager = gridLayoutManager
        appRecycleView.adapter = appAdapter


        appAdapter.setOnClickListener(object :
            AppAdapter.OnClickListener {
            override fun onClick(position: Int, model: ProductItem) {
                val id = model.id
                if (id > 0) {
                    val intent = Intent(this@HomeActivity, ProductDetailActivity::class.java)
                    intent.putExtra("itemID", id)
                    startActivity(intent)
                }
            }
        })
        searchButton.setOnClickListener {
            val query = searchText.text.toString()
            if (query.isEmpty()) {
                resultsTextView.text = "Please enter a search term"
            } else {
                resultsTextView.text = "No results found for \"$query\""
            }
        }



        val checkoutButton: View = findViewById(R.id.checkout_button)
        checkoutButton.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "The activity is visible and about to be started.")
    }


    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "The activity is visible and about to be restarted.")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "The activity is visible and has focus (it is now \"resumed\")")
    }

    override fun onPause() {
        super.onPause()
        Log.i(
            TAG,
            "Another activity is taking focus (this activity is about to be \"paused\")")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "The activity is no longer visible (it is now \"stopped\")")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "The activity is about to be destroyed.")
    }

}