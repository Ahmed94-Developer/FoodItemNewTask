package com.example.newtask.data.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.newtask.ui.fragment.FoodItemsFragment
import com.example.newtask.ui.fragment.RestaurantsFragment

class ViewPagerAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {

        when (position) {
            0 -> {
                return FoodItemsFragment()
            }
            1 -> {
                return RestaurantsFragment()
            }
        }
        return FoodItemsFragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return "FoodItem"
            }
            1 -> {
                return "Restaurants"
            }
        }
        return super.getPageTitle(position)
    }



}
