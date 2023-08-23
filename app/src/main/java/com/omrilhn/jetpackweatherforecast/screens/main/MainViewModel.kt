package com.omrilhn.jetpackweatherforecast.screens.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omrilhn.jetpackweatherforecast.data.DataOrException
import com.omrilhn.jetpackweatherforecast.model.Weather
import com.omrilhn.jetpackweatherforecast.model.WeatherObject
import com.omrilhn.jetpackweatherforecast.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//In order to get Information onto our UI
@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository )
    : ViewModel() {
        suspend fun getWeatherData(city : String)
        :DataOrException<Weather,Boolean,Exception>{
            return repository.getWeather(cityQuery = city)
        }

}
