package com.example.newtask.di

import com.example.newtask.retrofit.DataApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetWorkModule {
    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://dummyjson.com/")
            .build()
    }
    @Singleton
    @Provides
    fun provideDataApi(retrofit: Retrofit) : DataApi{
        return retrofit.create(DataApi::class.java)
    }

}