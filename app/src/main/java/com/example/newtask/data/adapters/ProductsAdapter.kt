package com.example.newtask.data.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.newtask.R
import com.example.newtask.retrofit.data.Product
import com.example.newtask.ui.activities.ItemDetailsActivity
import com.squareup.picasso.Picasso

class ProductsAdapter(val productlist: List<String>?) : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.choices_row, parent, false)
        return ProductsViewHolder(v)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val string: String = productlist!![position]
        Picasso.get().load(string).into(holder.image)



    }

    override fun getItemCount(): Int {
        return productlist!!.size
    }


    class ProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image : ImageView = itemView.findViewById(R.id.products_image)

    }
}

