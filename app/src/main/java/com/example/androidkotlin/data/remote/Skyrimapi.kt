package com.example.androidkotlin.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface Skyrimapi {
    @get:GET("Skyrimraceapi.json")
    val skyrimResponse: Call<RestSkyrimResponse>
}