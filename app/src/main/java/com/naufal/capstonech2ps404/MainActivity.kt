package com.naufal.capstonech2ps404

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.identity.Identity
import com.naufal.capstonech2ps404.data.retrofit.ApiConfig
import com.naufal.capstonech2ps404.data.retrofit.GoogleAuthClient
import com.naufal.capstonech2ps404.model.ResponseItem
import com.naufal.capstonech2ps404.style.AppTheme
import com.naufal.capstonech2ps404.ui.detail.Detail
import com.naufal.capstonech2ps404.ui.favorite.Favorite
import com.naufal.capstonech2ps404.ui.home.Dashboard
import com.naufal.capstonech2ps404.ui.login.Login
import com.naufal.capstonech2ps404.ui.notification.Notification
import com.naufal.capstonech2ps404.ui.register.Register
import com.naufal.capstonech2ps404.viewmodel.SignInViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ExampleClass {
    // Properti dengan tipe data String
    private var placeName: MutableList<ResponseItem> = mutableListOf()
    // Getter untuk myStringProperty
    fun getItems(): List<ResponseItem> {
        return placeName
    }

    // Setter untuk myStringProperty
    fun setItems(newValue: ResponseItem) {
        placeName.add(newValue)
    }
}
class MainActivity : AppCompatActivity() {
    private val googleAuthUiClient by lazy {
        GoogleAuthClient(
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val exampleObject = ExampleClass()
        super.onCreate(savedInstanceState)
        GlobalScope.launch(Dispatchers.IO) {
            val response = ApiConfig.getVacations().getPlaces("Jakarta")

            if (response.isSuccessful) {
                for (data in response.body()!!) {
                    exampleObject.setItems(data)
                    Log.i("Result Response", data.description.toString())

                }
            }
        }

        setContent {

            AppTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "Register",
                    ) {
                        composable("Testing") {
                            HomeScreen(exampleObject.getItems())
                        }
                        composable("Home") { Dashboard(exampleObject.getItems() ,navController) }
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
                            val dataItem = exampleObject.getItems().find { it.placeName == vacationId }
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

@Composable
fun HomeScreen(data: List<ResponseItem>) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn {
            items(data) { item ->
                ListItem(item.placeName.toString(), item.city.toString())
            }
        }
    }
}

@Composable
fun ListItem(placeName: String, city:String) {
    Text(
        text = placeName,
        modifier = Modifier.padding(16.dp)
    )
    Text(
        text = city,
        modifier = Modifier.padding(16.dp)
    )

}
