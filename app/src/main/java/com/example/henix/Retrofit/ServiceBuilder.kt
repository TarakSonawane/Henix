package com.example.henix.Retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://catfact.ninja/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()


        //Creating Instances of this object
        fun<T> buildService(service: Class<T>):T{
            return retrofit.create(service)
        }

}