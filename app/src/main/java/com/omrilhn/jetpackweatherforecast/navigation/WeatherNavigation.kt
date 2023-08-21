package com.omrilhn.jetpackweatherforecast.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.omrilhn.jetpackweatherforecast.screens.main.MainScreen
import com.omrilhn.jetpackweatherforecast.screens.main.MainViewModel
import com.omrilhn.jetpackweatherforecast.screens.splash.WeatherSplashScreen

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = WeatherScreens.SplashScreen.name){//when name is SplashScreen load this composable Screen
        composable(WeatherScreens.SplashScreen.name){
            WeatherSplashScreen(navController=navController)

        }
        composable(WeatherScreens.MainScreen.name){
            val mainViewModel = hiltViewModel<MainViewModel>()
            MainScreen(navController=navController,mainViewModel)

        }
    }
}