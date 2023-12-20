package com.naufal.capstonech2ps404.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.naufal.capstonech2ps404.style.backgroundColor
import com.naufal.capstonech2ps404.style.primaryColor
import com.naufal.capstonech2ps404.style.textColor

@Composable
fun CustomEmailField(label: String){
    val textValue = remember {
        mutableStateOf("")
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
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
    )
}