package com.naufal.capstonech2ps404.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naufal.capstonech2ps404.R
import com.naufal.capstonech2ps404.style.backgroundColor
import com.naufal.capstonech2ps404.style.primaryColor

@Composable
fun CustomElevatedButton(label: String){
    ElevatedButton(
        onClick = { },
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = primaryColor,
            contentColor = backgroundColor
        ),
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = label,
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
        )
    }
}

@Preview
@Composable
fun PreviewCustomElevatedButton(){
    CustomElevatedButton(stringResource(R.string.login))
}