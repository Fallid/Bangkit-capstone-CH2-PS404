package com.naufal.capstonech2ps404.ui.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.naufal.capstonech2ps404.R
import com.naufal.capstonech2ps404.state.SignInState
import com.naufal.capstonech2ps404.style.IconsApp
import com.naufal.capstonech2ps404.style.whiteSmoke

@Composable
fun GoogleSignIn(
    state: SignInState,
    onSignInClick: () -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = state.signInError) {
        state.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    IconButton(
        onClick = onSignInClick,
        colors = IconButtonDefaults.iconButtonColors(containerColor = whiteSmoke),
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Image(
            painter = painterResource(id = IconsApp.icGoogle),
            contentDescription = stringResource(
                id = R.string.google_icon
            )
        )

    }
}
