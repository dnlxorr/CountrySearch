package com.example.countrysearch.core.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroInstance {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://restcountries.com/v3.1/all/" )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}