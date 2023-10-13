package com.example.pogoda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.example.pogoda.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: WeatherViewModel
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text)
        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        viewModel.weatherData.observe(this, Observer { weather ->
            textView.text = weather ?: "Brak danych"
        })

        viewModel.error.observe(this, Observer { errorMessage ->
            // Opcjonalnie możesz wyświetlić komunikat o błędzie, np. za pomocą Toast:
            // Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            textView.text = errorMessage
        })

        viewModel.fetchWeather()
    }
}
