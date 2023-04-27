package com.example.henix.Retrofit

import com.example.henix.Models.ApiResponse

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers


interface ServiceInterface {

    @Headers("Content-Type:application/json")
    @GET("fact")

    fun gettallinfo(): Call<ApiResponse>


}