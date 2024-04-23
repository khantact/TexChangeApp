package com.example.texchange

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : ComponentActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)

        val appRecycleView = findViewById<RecyclerView>(R.id.recycle)

        val appArrayList: ArrayList<ProductItem> = Constants.getAppData()
        val appAdapter = AppAdapter(this, appArrayList)
        val gridLayoutManager = GridLayoutManager(this, 2)

        appRecycleView.layoutManager = gridLayoutManager
        appRecycleView.adapter = appAdapter

        appAdapter.setOnClickListener(object :
            AppAdapter.OnClickListener {
            override fun onClick(position: Int, model: ProductItem) {
                val id = model.getProductIDNum()
                if (id > 0) {
                    val intent = Intent(this@HomeActivity, ProductItemDetails::class.java)
                    intent.putExtra("itemID", id)
                    startActivity(intent)
                }
            }
        })
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