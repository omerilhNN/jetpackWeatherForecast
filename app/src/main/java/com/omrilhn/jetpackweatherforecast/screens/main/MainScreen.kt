package com.omrilhn.jetpackweatherforecast.screens.main

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.navigation.NavController
import com.omrilhn.jetpackweatherforecast.data.DataOrException
import com.omrilhn.jetpackweatherforecast.model.Weather

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel){
    ShowData(mainViewModel = mainViewModel)
}
@Composable
fun ShowData(mainViewModel: MainViewModel){
    val weatherData = produceState<DataOrException<Weather,Boolean,Exception>>(
        initialValue = DataOrException(loading = true)){
        value = mainViewModel.data.value
    }.value

    if(weatherData.loading == true){
        CircularProgressIndicator()
    }else if (weatherData.data !=null){
        Text(text = "MainScreen : ${weatherData.data!!.city.country}")
    }

    Text(text = "Main Screen")
}