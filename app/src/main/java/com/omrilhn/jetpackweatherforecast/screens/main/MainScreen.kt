@file:OptIn(ExperimentalMaterial3Api::class)

package com.omrilhn.jetpackweatherforecast.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.omrilhn.jetpackweatherforecast.WeatherApp
import com.omrilhn.jetpackweatherforecast.data.DataOrException
import com.omrilhn.jetpackweatherforecast.model.Weather
import com.omrilhn.jetpackweatherforecast.widgets.WeatherAppBar

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel){
    val weatherData = produceState<DataOrException<Weather,Boolean,Exception>>(
        initialValue = DataOrException(loading = true)){
        value = mainViewModel.getWeatherData(city="Seattle")
    }.value

    if(weatherData.loading == true){
        CircularProgressIndicator()
    }else if (weatherData.data !=null){
        MainScaffold(weather = weatherData.data!!,navController)

    }

}
@Composable
fun MainScaffold(weather: Weather, navController: NavController) {
    Scaffold(topBar = {
        WeatherAppBar(title =" Helena,MT")
    }) {innerPadding -> // padding calculated by scaffold
        // it doesn't have to be a column,
        // can be another component that accepts a modifier with padding
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding) // padding applied here
        ) {
            // all content should be here
            MainContent(data = weather)
        }
    }
}
@Composable
fun MainContent(data:Weather){
    Text(text = data.city.name)
}