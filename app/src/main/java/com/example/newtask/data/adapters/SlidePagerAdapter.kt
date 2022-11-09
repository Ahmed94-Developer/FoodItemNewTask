package com.example.newtask.data.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.newtask.ui.fragment.*

class SlidePagerAdapter  (fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {

        when (position) {
            0 -> {
                return FirstSlide()
            }
            1 -> {
                return SecondSlide()
            }
            2 -> {
                return ThirdSlide()
            }
        }
        return FirstSlide()
    }





}
