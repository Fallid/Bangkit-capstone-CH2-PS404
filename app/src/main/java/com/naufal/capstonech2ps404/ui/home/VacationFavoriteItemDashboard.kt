package com.naufal.capstonech2ps404.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.naufal.capstonech2ps404.style.backgroundColor
import com.naufal.capstonech2ps404.style.primaryColor

@Composable
fun VacationFavoriteItem(
    name: String,
    photoUrl: String,
    kota: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ), modifier = modifier
            .padding(end = 16.dp, start = 16.dp)
            .clickable(onClick = onClick)

    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .background(backgroundColor)
                .padding(end = 11.dp, start = 11.dp, bottom = 11.dp)
        ) {
            AsyncImage(
                model = photoUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .size(150.dp)
            )
            Text(
                text = name,
                fontWeight = FontWeight.Medium, fontSize = 16.sp
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "Location",
                        tint = primaryColor, modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = kota,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(fontSize = 10.sp),
                        modifier = Modifier.width(60.dp)
                    )

                }
                Text(text = "Rp.20.000", style = TextStyle(fontSize = 10.sp))
            }
        }
    }
}

@Preview
@Composable
fun PreviewVacationFavorite(){
    VacationFavoriteItem(name = "Pantai 3 Warna", photoUrl = "", kota = "Malang", onClick = { /*TODO*/ })
}