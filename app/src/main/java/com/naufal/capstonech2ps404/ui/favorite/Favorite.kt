package com.naufal.capstonech2ps404.ui.favorite

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Favorite(){
    Scaffold {
        innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)){
            item {
                Text(text = "INI FAVORITE PAGE")
            }
        }
    }
}

@Preview
@Composable
fun PreviewFavorite(){
    Favorite()
}