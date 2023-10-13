package com.example.pogoda.retrofit2

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object ApiService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://wttr.in/")
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    val weatherApi: WeatherApi = retrofit.create(WeatherApi::class.java)
}
