package com.naufal.capstonech2ps404.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.naufal.capstonech2ps404.style.IconsApp
import com.naufal.capstonech2ps404.ui.components.CustomEmailField
import com.naufal.capstonech2ps404.ui.components.CustomPasswordField
import com.naufal.capstonech2ps404.ui.components.CustomTextField

@Composable
fun Login() {

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
                contentDescription = "Icon Login",
                modifier = Modifier
                    .height(256.dp)
                    .padding(top = 16.dp, bottom = 32.dp)
            )
            Column {
                Text(
                    text = "Login Details",
                    style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 24.sp)
                )
                CustomEmailField(label = "Email")
                CustomPasswordField(label = "Password")

            }
        }
    }
}


@Preview
@Composable
fun PreviewLogin() {
    Login()
}