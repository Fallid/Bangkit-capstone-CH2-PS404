package com.naufal.capstonech2ps404.ui.register

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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.naufal.capstonech2ps404.R
import com.naufal.capstonech2ps404.style.IconsApp
import com.naufal.capstonech2ps404.style.primaryColor
import com.naufal.capstonech2ps404.ui.components.CustomElevatedButton
import com.naufal.capstonech2ps404.ui.components.CustomEmailField
import com.naufal.capstonech2ps404.ui.components.CustomPasswordField
import com.naufal.capstonech2ps404.ui.components.CustomTextField
import com.naufal.capstonech2ps404.ui.components.DividerGap

@Composable
fun Register(navController: NavController) {
    Scaffold { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
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
                    text = stringResource(R.string.register_details),
                    style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 24.sp)
                )
                CustomTextField(label = stringResource(R.string.full_name))
                CustomEmailField(label = stringResource(R.string.email))
                CustomPasswordField(label = stringResource(R.string.password))
                CustomElevatedButton(label = stringResource(R.string.register))
                DividerGap(label = stringResource(R.string.or))
                TextButton(onClick = { navController.navigate("Login") }) {
                    Text(
                        text = "Already have an account? sign in here", style = TextStyle(
                            color = primaryColor,
                            textDecoration = TextDecoration.Underline,
                            fontWeight = FontWeight.SemiBold
                        ), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewRegister() {
    val dummyRoute = rememberNavController()
    Register(dummyRoute)
}