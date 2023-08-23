@file:OptIn(ExperimentalMaterial3Api::class)

package com.omrilhn.jetpackweatherforecast.widgets

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//You need to set parameters by default because this is a PREVİEW fun
@Preview
@Composable
fun WeatherAppBar(
    title:String = "Title",
    icon: ImageVector?= null,
    isMainScreen:Boolean = true,
    elevation: Dp = 0.dp,
    onAddActionClicked:() ->Unit ={},
    onButtonClicked: () -> Unit = {}
){
    TopAppBar(title = {Text(text=title, color = MaterialTheme.colorScheme.onSecondary,
        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 15.sp)
    )})

}