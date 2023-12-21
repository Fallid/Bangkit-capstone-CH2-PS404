package com.naufal.capstonech2ps404.ui.notification

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.naufal.capstonech2ps404.ui.components.FabNavigation

@Composable
fun Notification(onSignOut: () -> Unit, navController: NavController) {
    Scaffold(floatingActionButton = { FabNavigation(navController = navController, 1)}) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            item {
                IconButton(onClick = onSignOut) {
                    Icon(imageVector = Icons.Filled.Logout, contentDescription ="Logout" )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewNotification() {
    val dummyRoute = rememberNavController()
    Notification( onSignOut = {} ,dummyRoute)
}