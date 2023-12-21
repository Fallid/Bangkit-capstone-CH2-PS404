package com.naufal.capstonech2ps404

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.naufal.capstonech2ps404.model.Dummy
import com.naufal.capstonech2ps404.style.AppTheme
import com.naufal.capstonech2ps404.ui.detail.Detail
import com.naufal.capstonech2ps404.ui.favorite.Favorite
import com.naufal.capstonech2ps404.ui.home.Dashboard
import com.naufal.capstonech2ps404.ui.login.Login
import com.naufal.capstonech2ps404.ui.notification.Notification
import com.naufal.capstonech2ps404.ui.register.Register

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold() { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = "Register",
                            modifier = Modifier.padding(innerPadding)
                        ) {

                            composable("Home") { Dashboard(navController) }
                            composable("Notification") { Notification(navController) }
                            composable("Favorite") { Favorite(navController) }
                            composable("Detail/{id}") { id ->
                                val vacationId = id.arguments?.getString("id")
                                val dataItem = Dummy.vacations.find { it.id == vacationId }
                                if (dataItem != null) {
                                    Detail(vacation = dataItem)
                                }
                            }
                            composable("Login"){ Login()}
                            composable("Register"){ Register(navController = navController)}
                        }
                    }
                }
            }
        }
    }
}