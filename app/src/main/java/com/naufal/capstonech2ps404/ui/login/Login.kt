package com.naufal.capstonech2ps404.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.naufal.capstonech2ps404.R
import com.naufal.capstonech2ps404.state.SignInState
import com.naufal.capstonech2ps404.style.IconsApp
import com.naufal.capstonech2ps404.style.primaryColor
import com.naufal.capstonech2ps404.ui.components.CustomElevatedButton
import com.naufal.capstonech2ps404.ui.components.CustomEmailField
import com.naufal.capstonech2ps404.ui.components.CustomPasswordField
import com.naufal.capstonech2ps404.ui.components.DividerGap
import com.naufal.capstonech2ps404.ui.components.GoogleSignIn
import com.naufal.capstonech2ps404.viewmodel.SignInViewModel

@Composable
fun Login(state: SignInState, onSignInClick: () -> Unit) {

    Scaffold { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(start = 24.dp, end = 24.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(IconsApp.icLogin),
                contentDescription = stringResource(R.string.icon_login),
                modifier = Modifier
                    .height(256.dp)
                    .padding(top = 16.dp, bottom = 32.dp)
            )
            Column {
                Text(
                    text = stringResource(R.string.login_details),
                    style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 24.sp)
                )
                CustomEmailField(label = stringResource(R.string.email))
                CustomPasswordField(label = stringResource(R.string.password))
                TextButton(onClick = { }) {
                    Text(
                        text = stringResource(R.string.forgot_password),
                        style = TextStyle(
                            color = primaryColor,
                            textDecoration = TextDecoration.Underline,
                            fontWeight = FontWeight.SemiBold
                        ),
                        textAlign = TextAlign.End,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CustomElevatedButton(label = stringResource(id = R.string.login))
                    DividerGap(label = stringResource(id = R.string.sign_up_with))
                    GoogleSignIn(state = state, onSignInClick = onSignInClick)
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewLogin() {
    val viewModel = viewModel<SignInViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    Login(state = state, onSignInClick = {})
}