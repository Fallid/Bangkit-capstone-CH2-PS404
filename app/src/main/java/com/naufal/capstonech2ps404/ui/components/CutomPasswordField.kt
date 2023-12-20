package com.naufal.capstonech2ps404.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.naufal.capstonech2ps404.style.backgroundColor
import com.naufal.capstonech2ps404.style.primaryColor
import com.naufal.capstonech2ps404.style.textColor


@Composable
fun CustomPasswordField(label: String) {
    val textValue = remember {
        mutableStateOf("")
    }
    val passwordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = textValue.value,
        onValueChange = { textValue.value = it },
        label = {
            Text(
                text = label
            )
        },
        shape = RoundedCornerShape(30.dp),
        colors = TextFieldDefaults.colors(
            //Styling container color
            unfocusedContainerColor = backgroundColor,
            focusedContainerColor = backgroundColor,
            errorContainerColor = backgroundColor,
            //Styling border color
            unfocusedIndicatorColor = primaryColor,
            focusedIndicatorColor = primaryColor,
            //
            focusedLabelColor = textColor,
            unfocusedLabelColor = textColor
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if (passwordVisible.value) {
                "Show Password"
            } else {
                "Hide Password"
            }

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value}) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        }, visualTransformation = if (passwordVisible.value){
            VisualTransformation.None}else{
            PasswordVisualTransformation()},
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    )
}

@Preview
@Composable
fun PreviewCustomPassword() {
    CustomPasswordField(label = "Password")
}