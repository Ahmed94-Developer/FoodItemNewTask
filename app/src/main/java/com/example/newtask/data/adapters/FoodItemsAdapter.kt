package com.example.newtask.data.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.newtask.R
import com.example.newtask.retrofit.data.Product
import com.example.newtask.ui.activities.ItemDetailsActivity
import com.squareup.picasso.Picasso

class FoodItemsAdapter(val productlist : List<Product>,val context: Context) : RecyclerView.Adapter<FoodItemsAdapter.FoodItemsViewHolder>() {
    var productslist: List<Product> = productlist


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.food_item_row,parent,false)
        return FoodItemsViewHolder(v)
    }

    override fun onBindViewHolder(holder: FoodItemsViewHolder, position: Int) {
        val product : Product = productlist[position]
        holder.titleTxt.setText(product.title)
        holder.descreptionTxt.setText(product.description)
        holder.rating_bar.rating = product.rating!!.toFloat()
        holder.price_txt.setText(product.price.toString())
        Picasso.get().load(product.thumbnail).into(holder.foodImage)
        holder.cardView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
               val intent = Intent(context,ItemDetailsActivity::class.java)
                val id = product.id.toString()
                intent.putExtra("id",id)
                context.startActivity(intent)
            }

        })
        holder.cart_layout.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                val intent = Intent(context,ItemDetailsActivity::class.java)
                val id = product.id.toString()
                intent.putExtra("id",id)
                context.startActivity(intent)
            }

        })


    }

    override fun getItemCount(): Int {
       return productlist.size
    }

    class FoodItemsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTxt : TextView = itemView.findViewById(R.id.title_txt)
        val descreptionTxt : TextView = itemView.findViewById(R.id.descreption_txt)

        val rating_bar : RatingBar = itemView.findViewById(R.id.ratingBar)
        val price_txt : TextView = itemView.findViewById(R.id.price_txt)

        val foodImage : ImageView = itemView.findViewById(R.id.imageView5)

        val cardView : CardView = itemView.findViewById(R.id.cart_item)

        val cart_layout : ConstraintLayout = itemView.findViewById(R.id.cart_layout)





      }

}