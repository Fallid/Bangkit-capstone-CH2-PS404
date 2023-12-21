package com.naufal.capstonech2ps404.ui.notification

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.naufal.capstonech2ps404.ui.components.FabNavigation

@Composable
fun Notification(navController: NavController) {
    Scaffold(floatingActionButton = { FabNavigation(navController = navController, 1)}) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            item {
                Text(text = "INI NOTIFICATION PAGE")
            }
        }
    }
}

@Preview
@Composable
fun PreviewNotification() {
    val dummyRoute = rememberNavController()
    Notification(dummyRoute)
}