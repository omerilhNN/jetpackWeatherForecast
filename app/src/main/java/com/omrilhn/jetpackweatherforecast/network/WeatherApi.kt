package com.omrilhn.jetpackweatherforecast.network

import com.omrilhn.jetpackweatherforecast.model.Weather
import com.omrilhn.jetpackweatherforecast.model.WeatherObject
import com.omrilhn.jetpackweatherforecast.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {
    @GET("data/2.5/forecast/daily")
    suspend fun getWeather(
        @Query("q") query:String,
        @Query("units") units: String = "imperial",
        @Query("appid") appid : String = Constants.API_KEY
    ): Weather
}