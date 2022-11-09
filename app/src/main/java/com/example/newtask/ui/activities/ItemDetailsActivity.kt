package com.example.newtask.ui.activities

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newtask.application.FoodItemApplication
import com.example.newtask.data.adapters.ProductsAdapter
import com.example.newtask.databinding.ActivityItemDetailsBinding
import com.example.newtask.viewmodel.ProductDetailsViewModel
import com.example.newtask.viewmodel.ProductDetailsViewModelFactory
import com.squareup.picasso.Picasso
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ItemDetailsActivity : AppCompatActivity() {

    @Inject
    lateinit var productDetailsViewModelFactory: ProductDetailsViewModelFactory
    private lateinit var productDetailsViewModel: ProductDetailsViewModel

    lateinit var bundle: Bundle

    lateinit var id : String

    private lateinit var binding: ActivityItemDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)




        (this.application as FoodItemApplication).applicationComponent.inject(this)
        productDetailsViewModel = ViewModelProvider(this,productDetailsViewModelFactory).get(ProductDetailsViewModel::class.java)

        val pd = ProgressDialog(this@ItemDetailsActivity)
        pd.setMessage("loading")
        pd.setCancelable(false)
        pd.show()

        GlobalScope.launch {
            bundle = intent.extras!!

            id = bundle.getString("id")!!
            Log.d("id",id)
            productDetailsViewModel.getProductDetails(id)
        }

        try {

            productDetailsViewModel.productsDetailsliveData.observe(this,Observer{
                Picasso.get().load(it.thumbnail).into(binding.productImage)
                binding.titleTxt.setText(it.title)
                binding.ratingTxt.setText(it.rating.toString())
                binding.priceTxt.setText(it.price.toString())
                binding.ratingBar2.rating = it.rating!!.toFloat()
                binding.descreptionTxt.setText(it.description)
                val productsAdapter : ProductsAdapter = ProductsAdapter(it.images)
                val linearLayoutManager : LinearLayoutManager = LinearLayoutManager(this@ItemDetailsActivity)
                binding.choicesRv.layoutManager = linearLayoutManager
                binding.choicesRv.adapter = productsAdapter
                pd.dismiss()

            })
            binding.imageButton2.setOnClickListener(object :View.OnClickListener{
                override fun onClick(p0: View?) {
                    finish()
                }

            })


        }catch (e : Exception){
            e.printStackTrace()
            pd.dismiss()
        }
    }
}