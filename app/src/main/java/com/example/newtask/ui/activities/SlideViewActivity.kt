package com.example.newtask.ui.activities

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import com.example.newtask.data.adapters.SlidePagerAdapter

import com.example.newtask.databinding.ActivityMainBinding
import com.example.newtask.databinding.ActivitySlideViewBinding
import com.google.android.gms.dynamic.SupportFragmentWrapper


class SlideViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySlideViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySlideViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapter: SlidePagerAdapter = SlidePagerAdapter(supportFragmentManager)
        binding.photosViewpager.adapter = adapter

        binding.tabLayout.setupWithViewPager(binding.photosViewpager)

        binding.floatingActionButton.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                startActivity(Intent(this@SlideViewActivity,MainActivity::class.java))
            }

        })
    }
}