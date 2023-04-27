package com.example.henix.Models

import com.google.gson.annotations.SerializedName


data class ApiResponse (

    @SerializedName("fact") var fact : String,
    @SerializedName("length") var length : String

)
