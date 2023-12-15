package com.naufal.capstonech2ps404.ui.home

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.naufal.capstonech2ps404.data.VacationRepository
import com.naufal.capstonech2ps404.style.backgroundColor
import com.naufal.capstonech2ps404.viewmodel.VacationsViewModel
import com.naufal.capstonech2ps404.viewmodel.ViewModelFactory


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Dashboard(
    navigation: NavController,
    modifier: Modifier = Modifier,
    viewModel: VacationsViewModel = viewModel(factory = ViewModelFactory(VacationRepository()))
) {
    val groupedVacations by viewModel.groupedVacation.collectAsState()
    val query by viewModel.query
    val listState = rememberLazyListState()
    Scaffold(
        topBar = { SearchBarLayout(query = query, onQueryChange = viewModel::search) },
        floatingActionButton = {
            fabDashboard()
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(backgroundColor)
        ) {
            LazyRow(
                state = listState,
                modifier = Modifier
                    .height(270.dp)
                    .background(backgroundColor)
            ) {
                groupedVacations.forEach { (_, vacations) ->
                    items(vacations, key = { it.id }) { vacation ->
                        VacationFavoriteItem(
                            name = vacation.name,
                            photoUrl = vacation.photoUrl,
                            kota = vacation.kota,
                            onClick = {
//                                navigation.navigate("detail_page/${vacation.id}")
                            },
                            modifier = Modifier
                                .width(200.dp)
                                .heightIn(min = 250.dp)
                                .height(250.dp)
                                .background(backgroundColor)
                                .animateItemPlacement(tween(durationMillis = 100))
                        )
                    }
                }
            }
            Text(text = "Malang")
        }
    }
}


@Preview
@Composable
fun DashboardPreview() {
    val navDummy = rememberNavController()
    Dashboard(navigation = navDummy)
}