package com.naufal.capstonech2ps404.ui.home

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.naufal.capstonech2ps404.data.repository.VacationRepository
import com.naufal.capstonech2ps404.model.ResponseItem
import com.naufal.capstonech2ps404.style.backgroundColor
import com.naufal.capstonech2ps404.style.primaryColor
import com.naufal.capstonech2ps404.ui.components.FabNavigation
import com.naufal.capstonech2ps404.viewmodel.VacationsViewModel
import com.naufal.capstonech2ps404.viewmodel.ViewModelFactory


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Dashboard(
    data: List<ResponseItem>,
    navigation: NavController,
    viewModel: VacationsViewModel = viewModel(factory = ViewModelFactory(VacationRepository()))
) {
//    val groupedVacations by viewModel.groupedVacation.collectAsState()
    val query by viewModel.query
//    val listState = rememberLazyListState()
    Scaffold(
        topBar = { SearchBarLayout(query = query, onQueryChange = viewModel::search) }, floatingActionButton = {
            FabNavigation(
                navController = navigation, 0
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(backgroundColor)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth()) {
                Text(text = "Tourism", style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold ))
                TextButton(onClick = {  }, ) {
                    Text(text = "See All", style = TextStyle(color = primaryColor))
                }
            }
            LazyRow(

                modifier = Modifier
                    .height(270.dp)
                    .background(backgroundColor)
            ) {

//                data.forEach { (_, vacations) ->
                    items(data) { vacation ->
                        VacationFavoriteItem(
                            name = vacation.placeName.toString(),
                            photoUrl = vacation.images.toString(),
                            kota = vacation.city.toString(),
                            onClick = {
                                navigation.navigate("Detail/${vacation.placeName}")
                            },
                            modifier = Modifier
                                .width(200.dp)
                                .heightIn(min = 250.dp)
                                .height(250.dp)
                                .background(backgroundColor)
                                .animateItemPlacement(tween(durationMillis = 100))
                        )
                    }
//                }
            }
            TabLayoutDashboard()
        }
    }
}


@Preview
@Composable
fun DashboardPreview() {
    val placeName: MutableList<ResponseItem> = mutableListOf()
    val dummyNavigation = rememberNavController()
    Dashboard(placeName,dummyNavigation)
}