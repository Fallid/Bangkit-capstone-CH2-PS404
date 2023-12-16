package com.naufal.capstonech2ps404.ui.favorite

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.naufal.capstonech2ps404.ui.home.FabDashboard

@Composable
fun Favorite(navController: NavController){
    Scaffold(floatingActionButton = { FabDashboard(navController = navController)}) {
        innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)){}
    }
}

@Preview
@Composable
fun PreviewFavorite(){
    val dummyRoute = rememberNavController()
    Favorite(navController = dummyRoute)
}