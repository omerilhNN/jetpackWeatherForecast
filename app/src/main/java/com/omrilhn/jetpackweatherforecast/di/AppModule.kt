package com.omrilhn.jetpackweatherforecast.di

import com.omrilhn.jetpackweatherforecast.model.Weather
import com.omrilhn.jetpackweatherforecast.network.WeatherApi
import com.omrilhn.jetpackweatherforecast.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module // You declare dependencies here
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providesOpenWeatherApi():WeatherApi{ // WE ARE NOT GONNA CALL THİS FUNCTION HILT AND DAGGER WILL DO SMTH IN BACKGROUND
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }
}