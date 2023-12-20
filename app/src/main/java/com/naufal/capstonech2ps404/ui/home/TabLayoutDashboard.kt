package com.naufal.capstonech2ps404.ui.home

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.naufal.capstonech2ps404.data.VacationRepository
import com.naufal.capstonech2ps404.model.TabLayoutItem
import com.naufal.capstonech2ps404.style.IconsApp
import com.naufal.capstonech2ps404.style.backgroundColor
import com.naufal.capstonech2ps404.style.secondaryContainer
import com.naufal.capstonech2ps404.viewmodel.VacationsViewModel
import com.naufal.capstonech2ps404.viewmodel.ViewModelFactory


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayoutDashboard(
    viewModel: VacationsViewModel = viewModel(
        factory = ViewModelFactory(
            VacationRepository()
        )
    )
) {
    val groupedVacations by viewModel.groupedVacation.collectAsState()
    val query by viewModel.query
    val listState = rememberLazyListState()
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    val tabItem = listOf<TabLayoutItem>(
        TabLayoutItem(
            city = "Malang",
            unselectedIcon = painterResource(id = IconsApp.iCompass),
            selectedIcon = painterResource(id = IconsApp.iCompass)
        ),
        TabLayoutItem(
            city = "Surabaya",
            unselectedIcon = painterResource(id = IconsApp.iCompass),
            selectedIcon = painterResource(id = IconsApp.iCompass)
        ),
        TabLayoutItem(
            city = "Bandung",
            unselectedIcon = painterResource(id = IconsApp.iCompass),
            selectedIcon = painterResource(id = IconsApp.iCompass)
        ),
    )
    val pagerState = rememberPagerState {
        tabItem.size
    }
    LaunchedEffect(selectedIndex) {
        pagerState.animateScrollToPage(selectedIndex)
    }
    LaunchedEffect(pagerState) {
        selectedIndex = pagerState.currentPage
    }
    Column(modifier = Modifier.fillMaxSize()) {
        ScrollableTabRow(selectedTabIndex = selectedIndex) {
            tabItem.forEachIndexed { index, tabLayoutItem ->
                Tab(
                    selected = index == selectedIndex,
                    onClick = { selectedIndex = index },
                    text = {
                        Text(
                            text = tabLayoutItem.city
                        )
                    },
                    icon = {
                        Icon(
                            painter = tabLayoutItem.selectedIcon,
                            contentDescription = "City"
                        )
                    })
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(backgroundColor)
            ) {
                groupedVacations.forEach { (_, vacations) ->
                    items(vacations, key = { it.id }) { vacation ->
                        VacationListItem(
                            name = vacation.name,
                            photoUrl = vacation.photoUrl,
                            onClick = {
//                                navigation.navigate("detail_page/${vacation.id}")
                            },
                            modifier = Modifier
                                .padding(bottom = 20.dp, start = 16.dp, end = 16.dp)
                                .clip(shape = RoundedCornerShape(18.dp))
                                .fillMaxWidth()
                                .heightIn(min = 48.dp)
                                .height(81.dp)
                                .background(secondaryContainer)
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
fun PreviewTabLayout() {
    TabLayoutDashboard()
}
