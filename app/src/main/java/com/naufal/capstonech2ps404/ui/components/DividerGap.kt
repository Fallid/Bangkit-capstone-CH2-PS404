package com.naufal.capstonech2ps404.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naufal.capstonech2ps404.style.textColor

@Composable
fun DividerGap(label: String){
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), color = textColor, thickness = 1.dp
        )
        Text(
            text = label,
            style = TextStyle(fontSize = 14.sp, color = textColor),
            modifier = Modifier.padding(start = 6.dp, end = 6.dp)
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), color = textColor, thickness = 1.dp
        )
    }
}

@Preview
@Composable
fun PreviewDividerGap(){
    DividerGap(label = "or")
}