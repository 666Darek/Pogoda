package com.example.pogoda.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.pogoda.retrofit2.ApiService

class WeatherViewModel : ViewModel() {

    val weatherData = MutableLiveData<String>()
    val error = MutableLiveData<String>()

    fun fetchWeather() {
        viewModelScope.launch {
            try {
                val response = ApiService.weatherApi.getWeather()
                if (response.isSuccessful) {
                    weatherData.postValue(response.body())
                } else {
                    error.postValue("Błąd: ${response.code()}")
                }
            } catch (e: Exception) {
                error.postValue(e.localizedMessage)
            }
        }
    }
}