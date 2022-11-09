package com.example.newtask.ui.activities

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import com.example.newtask.R
import com.example.newtask.data.adapters.ViewPagerAdapter
import com.example.newtask.databinding.ActivitySideMenuBinding
import com.google.android.material.tabs.TabLayout
import com.special.ResideMenu.ResideMenu
import com.special.ResideMenu.ResideMenu.OnMenuListener
import com.special.ResideMenu.ResideMenuItem


class SideMenuActivity : AppCompatActivity(),View.OnClickListener{
    private lateinit var resideMenu: ResideMenu
    private val mContext: Context? = null
    private var itemHome: ResideMenuItem? = null
    private var itemProfile: ResideMenuItem? = null
    private var itemDeliveryAccess: ResideMenuItem? = null
    private var itemSettings: ResideMenuItem? = null
    private var itemContact : ResideMenuItem?= null
    private var itemLogOut : ResideMenuItem?= null
    private var itemPaymentMethods:ResideMenuItem?= null

    private lateinit var binding: ActivitySideMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySideMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

         resideMenu = ResideMenu(this)


     //   resideMenu.setBackground(R.drawable.menu_background);
        resideMenu.attachToActivity(this)
       // resideMenu.setMenuListener(menuListener);
        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip.
        resideMenu.setScaleValue(0.6f)
        resideMenu.setBackground(R.drawable.menu_color)

        itemHome = ResideMenuItem(this, com.example.newtask.R.drawable.ic_baseline_orders_24, "Orders")
        itemProfile = ResideMenuItem(this, com.example.newtask.R.drawable.ic_baseline_person_24, "Profile")
        itemDeliveryAccess = ResideMenuItem(this,com.example.newtask.R.drawable.ic_baseline_location_on_24, "Access")
        itemSettings = ResideMenuItem(this, com.example.newtask.R.drawable.ic_baseline_settings_24, "Settings")
        itemContact = ResideMenuItem(this, R.drawable.ic_baseline_email_24,"Contact")
        itemPaymentMethods = ResideMenuItem(this,R.drawable.ic_payment_method_svgrepo_com,"Pay")
        itemDeliveryAccess = ResideMenuItem(this,R.drawable.ic_baseline_location_on_24,"Access")
        itemLogOut = ResideMenuItem(this,R.drawable.ic_log_out,"LogOut")


        itemHome!!.setOnClickListener(this)

        itemProfile!!.setOnClickListener(this)
        itemDeliveryAccess!!.setOnClickListener(this)
        itemSettings!!.setOnClickListener(this)

        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT)
        resideMenu.addMenuItem(itemProfile, ResideMenu.DIRECTION_LEFT)
        resideMenu.addMenuItem(itemDeliveryAccess,ResideMenu.DIRECTION_LEFT)
        resideMenu.addMenuItem(itemPaymentMethods,ResideMenu.DIRECTION_LEFT)
        resideMenu.addMenuItem(itemSettings, ResideMenu.DIRECTION_LEFT)
        resideMenu.addMenuItem(itemContact,ResideMenu.DIRECTION_LEFT)
        resideMenu.addMenuItem(itemLogOut,ResideMenu.DIRECTION_LEFT)




        binding.rightBarMenu.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }

        })
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Food Item"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Restuarant"))
        setTabBG(R.drawable.menu_color,R.drawable.restaurant_bg)
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
       

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if(binding.tabLayout.getSelectedTabPosition()==0) {
                    setTabBG(R.drawable.menu_color,R.drawable.restaurant_bg)
                }
                else {
                    setTabBG(R.drawable.restaurant_bg,R.drawable.menu_color)
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
                setTabBG(R.drawable.restaurant_bg,R.drawable.menu_color);
            }


            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

        })




    }
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return resideMenu.dispatchTouchEvent(ev)

    }

    override fun onClick(p0: View?) {
       Toast.makeText(this@SideMenuActivity,"Clicked",Toast.LENGTH_LONG).show()
    }
    private val menuListener: OnMenuListener = object : OnMenuListener {
        override fun openMenu() {
            Toast.makeText(mContext, "Menu is opened!", Toast.LENGTH_SHORT).show()
        }

        override fun closeMenu() {
            Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show()
        }
    }
    fun getResideMenu(): ResideMenu? {
        return resideMenu
    }
    private fun setTabBG(tab1: Int, tab2: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            val tabStrip = binding.tabLayout.getChildAt(0) as ViewGroup
            val tabView1 = tabStrip.getChildAt(0)
            val tabView2 = tabStrip.getChildAt(1)
            if (tabView1 != null) {
                val paddingStart = tabView1.paddingStart
                val paddingTop = tabView1.paddingTop
                val paddingEnd = tabView1.paddingEnd
                val paddingBottom = tabView1.paddingBottom
                ViewCompat.setBackground(
                    tabView1,
                    AppCompatResources.getDrawable(tabView1.context, tab1)
                )
                ViewCompat.setPaddingRelative(
                    tabView1,
                    paddingStart,
                    paddingTop,
                    paddingEnd,
                    paddingBottom
                )
            }
            if (tabView2 != null) {
                val paddingStart = tabView2.paddingStart
                val paddingTop = tabView2.paddingTop
                val paddingEnd = tabView2.paddingEnd
                val paddingBottom = tabView2.paddingBottom
                ViewCompat.setBackground(
                    tabView2,
                    AppCompatResources.getDrawable(tabView2.context, tab2)
                )
                ViewCompat.setPaddingRelative(
                    tabView2,
                    paddingStart,
                    paddingTop,
                    paddingEnd,
                    paddingBottom
                )
            }
        }
    }
}