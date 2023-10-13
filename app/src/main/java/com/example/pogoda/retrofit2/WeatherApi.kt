package com.example.pogoda.retrofit2

import retrofit2.Response
import retrofit2.http.GET

interface WeatherApi {
    @GET("Warsaw?format=%t+%w")
    suspend fun getWeather(): Response<String>
}
