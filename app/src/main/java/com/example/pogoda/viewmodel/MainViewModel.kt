package com.example.pogoda.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel() {
    val numberLiveData = MutableLiveData<String>()

    init {
        Timer().scheduleAtFixedRate(object: TimerTask() {
            var count = 0
            override fun run() {
                numberLiveData.postValue((count++).toString())
            }
        }, 0, 1000) // co 1 sekundę
    }
}
