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
    : ViewModel(){
        val data : MutableState<DataOrException<Weather,Boolean,Exception>>
            = mutableStateOf(DataOrException(null,true,Exception("")))
    init{
        loadWeather()
    }

    private fun loadWeather() {
        getWeather("Seattle")
    }

    private fun getWeather(city: String) {
        viewModelScope.launch {//Because we are gonna call suspend fun\\
            // viewModelScope, ViewModel sınıflarında asenkron işlemleri yönetmek için kullanılan bir kapsam nesnesidir ve bu sayede işlemlerin uygun bir şekilde yaşam döngüsüne entegre edilmesini sağlar.
            if(city.isEmpty()) return@launch
            data.value.loading = true
            data.value = repository.getWeather(cityQuery = city)
            if(data.value.data.toString().isNotEmpty()) data.value.loading = false
        }
        Log.d("get","GET Weather: ${data.value.data.toString()}")
    }
}