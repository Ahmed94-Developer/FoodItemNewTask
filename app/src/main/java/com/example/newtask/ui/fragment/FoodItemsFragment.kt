package com.example.newtask.ui.fragment

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.newtask.R
import com.example.newtask.application.FoodItemApplication
import com.example.newtask.data.adapters.FoodItemsAdapter
import com.example.newtask.viewmodel.FoodItemViewModelFactory
import com.example.newtask.viewmodel.FoodItemsViewModel
import javax.inject.Inject


class FoodItemsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    @Inject
    lateinit var foodItemViewModelFactory: FoodItemViewModelFactory
    private lateinit var foodItemsViewModel: FoodItemsViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view : View = inflater.inflate(R.layout.fragment_food_items, container, false)
         val recyclerView : RecyclerView = view.findViewById(R.id.rv)

        (requireActivity().application as FoodItemApplication).applicationComponent.inject(this)
        foodItemsViewModel = ViewModelProvider(this,foodItemViewModelFactory).get(FoodItemsViewModel::class.java)

        val pd = ProgressDialog(requireActivity())
        pd.setMessage("loading")
        pd.setCancelable(false)
        pd.show()

          try {
              foodItemsViewModel.foodItemsLiveData.observe(requireActivity(), Observer {
                  val foodItemsAdapter = FoodItemsAdapter(it.products!!,requireActivity())
                  pd.dismiss()
                  val staggeredGridLayoutManager:StaggeredGridLayoutManager =
                      StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
                  recyclerView.layoutManager = staggeredGridLayoutManager
                  recyclerView.adapter = foodItemsAdapter

              })
          }catch (e : Exception){
              e.printStackTrace()
              pd.dismiss()
          }


        return view
    }

}