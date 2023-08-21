package com.omrilhn.jetpackweatherforecast.repository

import com.omrilhn.jetpackweatherforecast.data.DataOrException
import com.omrilhn.jetpackweatherforecast.model.Weather
import com.omrilhn.jetpackweatherforecast.model.WeatherObject
import com.omrilhn.jetpackweatherforecast.network.WeatherApi
import javax.inject.Inject

//That is going to directly get data from WeatherApi
// have access to getWeather suspended function

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//With the constructor you can have access to Weather Api
class WeatherRepository @Inject constructor(private val api: WeatherApi) {
    suspend fun getWeather(cityQuery: String):DataOrException<Weather,Boolean,Exception>{
        val response = try{
            api.getWeather(query = cityQuery)
        }catch (e: Exception){
            return DataOrException(e = e)
        }
        return DataOrException(data = response)


    }
}