package com.naufal.capstonech2ps404.ui.detail

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.naufal.capstonech2ps404.ExampleClass
import com.naufal.capstonech2ps404.model.ResponseItem
import com.naufal.capstonech2ps404.style.IconsApp
import com.naufal.capstonech2ps404.style.orange
import com.naufal.capstonech2ps404.style.primaryColor
import com.naufal.capstonech2ps404.style.whiteSmoke

@Composable
fun Detail(vacation: ResponseItem?) {
    val onNavigateBack = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    val isBookmarked = false
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box {
                AsyncImage(
                    model = vacation?.images,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(300.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(bottomEnd = 8.dp, bottomStart = 8.dp))
                )
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    OutlinedButton(
                        onClick = { onNavigateBack?.onBackPressed() },
                        modifier = Modifier
                            .size(50.dp)
                            .padding(8.dp)
                            .clip(CircleShape)
                            .background(whiteSmoke),
                        shape = CircleShape,
                        border = null,
                        contentPadding = PaddingValues(0.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = primaryColor
                        )
                    ) {
                        Icon(
                            painterResource(id = IconsApp.icBackBtn),
                            contentDescription = null,
                        )
                    }

                    if (isBookmarked == true) {
                        TravelStatusBar(
                            thumbnail = vacation?.images.toString(),
                            name = vacation?.placeName.toString(),
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 4.dp)
                        )
                    } else {
                        Spacer(modifier = Modifier.weight(1.0f))
                    }
                    OutlinedButton(
                        onClick = {},
                        modifier = Modifier
                            .size(50.dp)
                            .padding(8.dp)
                            .clip(CircleShape)
                            .background(whiteSmoke),
                        shape = CircleShape,
                        border = null,
                        contentPadding = PaddingValues(0.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = primaryColor
                        )
                    ) {
                        Icon(
                            painterResource(
                                id = if (isBookmarked == true) {
                                    IconsApp.icBookmarkFilled
                                } else {
                                    IconsApp.icBookmarkUnfilled
                                }
                            ),
                            contentDescription = null,
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                vacation?.placeName?.let {
                    Text(
                        text = it,
                        fontSize = 32.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth(0.5f),
                        lineHeight = 40.sp,
                    )
                }

                Spacer(modifier = Modifier.weight(1.0f))

                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(whiteSmoke)
                        .padding(8.dp),
                    verticalAlignment = Alignment.Bottom

                ) {
                    vacation?.price?.let {
                        Text(
                            text = it.toString(),
                            fontSize = 28.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "/person",
                            fontSize = 18.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            Text(
                text = "Overview",
                color = primaryColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )

            Row (
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                vacation?.rating?.let { VacationCharacter(iconId = IconsApp.icDuration, title = "Duration", color = primaryColor,  value = it.toString()) }
                Spacer(modifier = Modifier.weight(1.0f))
                vacation?.rating?.let { VacationCharacter(iconId = IconsApp.icRating, title = "Rating", color = orange, value = it.toString()) }
            }

            vacation?.description?.let {
                Text(
                    text = it,
                    color = Color.Gray,
                    modifier = Modifier.padding(16.dp),
                    fontSize = 12.sp,
                )
            }

            Spacer(modifier = Modifier.weight(1.0f))

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .height(50.dp)
                    .padding(horizontal = 32.dp)
                    .clip(RoundedCornerShape(16.dp))

            ) {
                Text(text = "More Recommendation")
            }
        }
    }
}


@Composable
fun VacationCharacter(
    iconId: Int,
    title: String,
    value: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(50.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = null,
            modifier = Modifier
                .height(40.dp)
                .width(40.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(whiteSmoke)
                .padding(5.dp),
            colorFilter = ColorFilter.tint(color)
        )

        Column(
            modifier = Modifier
                .padding(start = 8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title.uppercase(),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )
        }
    }
}
@Composable
fun TravelStatusBar(
    thumbnail: String,
    name: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        AsyncImage(
            model = thumbnail,
            contentDescription = null,
            modifier = Modifier
                .height(40.dp)
                .width(40.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Column(
            modifier = Modifier
                .padding(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = name,
                fontSize = 12.sp,
            )
            Text(
                text = "Added in Read List",
                fontSize = 10.sp,
                color = primaryColor
            )
        }
        Spacer(modifier = Modifier.weight(1.0f))

        Text(
            text = "Read Now",
            modifier = Modifier.clickable {  }
        )

    }
}


@Preview
@Composable
fun PreviewDetail() {
    val exampleObject = ExampleClass()
    val dataItem = exampleObject.getItems().find { it.placeName == "Jakarta" }
    if (dataItem != null) {
        Detail(vacation = dataItem)
    }
}