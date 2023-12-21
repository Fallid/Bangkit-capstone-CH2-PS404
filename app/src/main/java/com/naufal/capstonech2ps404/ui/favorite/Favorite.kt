package com.naufal.capstonech2ps404.ui.favorite

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.naufal.capstonech2ps404.data.VacationRepository
import com.naufal.capstonech2ps404.style.backgroundColor
import com.naufal.capstonech2ps404.ui.components.FabNavigation
import com.naufal.capstonech2ps404.ui.home.SearchBarLayout
import com.naufal.capstonech2ps404.ui.home.VacationFavoriteItem
import com.naufal.capstonech2ps404.viewmodel.VacationsViewModel
import com.naufal.capstonech2ps404.viewmodel.ViewModelFactory

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Favorite(navController: NavController ,viewModel: VacationsViewModel = viewModel(factory = ViewModelFactory(VacationRepository()))) {
    val groupedVacations by viewModel.groupedVacation.collectAsState()
    val query by viewModel.query
    val listState = rememberLazyGridState()
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Whist List",
                    style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                )
            },
        )
    }, floatingActionButton = { FabNavigation(navController = navController, 2)}) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            SearchBarLayout(query = query, onQueryChange = viewModel::search)
            LazyVerticalGrid(
                columns = GridCells.Adaptive(170.dp),
                state = listState,
                verticalArrangement = Arrangement.SpaceAround,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
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
                                .padding(bottom = 16.dp)
                                .animateItemPlacement(tween(durationMillis = 100))
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewFavorite() {
    val dummyRoute = rememberNavController()
    Favorite(dummyRoute)
}