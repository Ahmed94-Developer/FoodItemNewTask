package com.example.newtask.application

import android.content.Context
import com.example.newtask.di.NetWorkModule
import com.example.newtask.ui.activities.ItemDetailsActivity
import com.example.newtask.ui.fragment.FoodItemsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetWorkModule::class])
interface ApplicationComponent {

    fun inject(foodItemsFragment: FoodItemsFragment)
    fun inject(itemDetailsActivity: ItemDetailsActivity)

    @Component.Factory
    interface factory{
        fun create(@BindsInstance context: Context) : ApplicationComponent

    }


}