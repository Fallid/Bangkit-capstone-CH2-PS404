package com.naufal.capstonech2ps404

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.identity.Identity
import com.naufal.capstonech2ps404.data.retrofit.GoogleAuthClient
import com.naufal.capstonech2ps404.model.Dummy
import com.naufal.capstonech2ps404.style.AppTheme
import com.naufal.capstonech2ps404.ui.detail.Detail
import com.naufal.capstonech2ps404.ui.favorite.Favorite
import com.naufal.capstonech2ps404.ui.home.Dashboard
import com.naufal.capstonech2ps404.ui.login.Login
import com.naufal.capstonech2ps404.ui.notification.Notification
import com.naufal.capstonech2ps404.ui.register.Register
import com.naufal.capstonech2ps404.viewmodel.SignInViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val googleAuthUiClient by lazy {
        GoogleAuthClient(
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "Login",
                    ) {

                        composable("Home") { Dashboard(navController) }
                        composable("Notification") {
                            Notification(onSignOut = {
                                lifecycleScope.launch {
                                    googleAuthUiClient.signOut()
                                    Toast.makeText(
                                        applicationContext,
                                        "Signed out",
                                        Toast.LENGTH_LONG
                                    ).show()

                                    navController.popBackStack()
                                }
                            }, navController)
                        }
                        composable("Favorite") { Favorite(navController) }
                        composable("Detail/{id}") { id ->
                            val vacationId = id.arguments?.getString("id")
                            val dataItem = Dummy.vacations.find { it.id == vacationId }
                            if (dataItem != null) {
                                Detail(vacation = dataItem)
                            }
                        }
                        composable("Login") {
                            val viewModel = viewModel<SignInViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()

                            LaunchedEffect(key1 = Unit) {
                                if (googleAuthUiClient.getSignedInUser() != null) {
                                    navController.navigate("Home")
                                }
                            }
                            val launcher = rememberLauncherForActivityResult(
                                contract = ActivityResultContracts.StartIntentSenderForResult(),
                                onResult = { result ->
                                    if (result.resultCode == RESULT_OK) {
                                        lifecycleScope.launch {
                                            val signInResult =
                                                googleAuthUiClient.signInWithIntent(
                                                    intent = result.data ?: return@launch
                                                )
                                            viewModel.onSignInResult(signInResult)
                                        }
                                    }
                                }
                            )
                            LaunchedEffect(key1 = state.isSignInSuccessful) {
                                if (state.isSignInSuccessful) {
                                    Toast.makeText(
                                        applicationContext,
                                        "Sign in successful",
                                        Toast.LENGTH_LONG
                                    ).show()

                                    navController.navigate("Home")
                                    viewModel.resetState()
                                }
                            }
                            Login(state = state, onSignInClick = {
                                lifecycleScope.launch {
                                    val signInIntentSender = googleAuthUiClient.signIn()
                                    launcher.launch(
                                        IntentSenderRequest.Builder(
                                            signInIntentSender ?: return@launch
                                        ).build()
                                    )
                                }
                            })
                        }
                        composable("Register") { Register(navController = navController) }
                    }
                }
            }
        }
    }
}
