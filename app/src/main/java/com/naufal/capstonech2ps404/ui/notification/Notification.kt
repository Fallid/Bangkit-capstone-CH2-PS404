package com.naufal.capstonech2ps404.ui.notification

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Notification() {
    Scaffold() { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            item {
                Text(text = "INI NOTIFICATION PAGE")
            }
        }
    }
}

@Preview
@Composable
fun PreviewNotification() {
    Notification()
}