package com.example.texchange

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AppAdapter(private val context: HomeActivity, productArrayList: List<ProductItem>) :
    RecyclerView.Adapter<AppAdapter.ViewHolder>() {

    private val productArrayList: List<ProductItem>
    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: ProductItem = productArrayList[position]
        holder.productPic.setImageResource(model.getProductPic())
        holder.productName.text = model.getProductName()
        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, model)
            }
        }
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    init {
        this.productArrayList = productArrayList
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productPic: ImageView
        val productName: TextView
        //val productPrice : TextView
        init {
            productPic = itemView.findViewById(R.id.img)
            productName = itemView.findViewById(R.id.text)
            //productPrice = itemView.findViewById(R.id.details)
        }
    }

    interface OnClickListener {
        fun onClick(position: Int, model: ProductItem)
    }
}