package com.naufal.capstonech2ps404.ui

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.naufal.capstonech2ps404.data.VacationRepository
import com.naufal.capstonech2ps404.model.ButtonNavigationItem
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
        topBar = { AppBarDashboard() },
        floatingActionButton = {
            fabDashboard()
        }) { innerPadding ->
        LazyColumn(state = listState, modifier = Modifier.padding(innerPadding)) {
            item { }
            groupedVacations.forEach { (_, vacations) ->
                items(vacations, key = { it.id }) { vacation ->
                    VacationListItem(
                        name = vacation.name,
                        photoUrl = vacation.photoUrl,
                        onClick = { navigation.navigate("detail_page/${vacation.id}") },
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .animateItemPlacement(tween(durationMillis = 100))
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarDashboard() {
    TopAppBar(title = { Text(text = "Dashboard") })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun fabDashboard() {
    val listState = rememberLazyListState()
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    val item = listOf(
        ButtonNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false
        ),
        ButtonNavigationItem(
            title = "Notification",
            selectedIcon = Icons.Filled.Notifications,
            unselectedIcon = Icons.Outlined.Notifications,
            hasNews = false,
        ),
        ButtonNavigationItem(
            title = "Favorite",
            selectedIcon = Icons.Filled.Menu,
            unselectedIcon = Icons.Outlined.Menu,
            hasNews = false
        )
    )
    NavigationBar {
        item.forEachIndexed { index, buttonNavigationItem ->
            NavigationBarItem(selected = selectedItemIndex == index, onClick = {
                selectedItemIndex = index
//                navController.navigate(item.title)
            }, icon = {
                BadgedBox(badge = {}) {
                    Icon(
                        imageVector = if (index == selectedItemIndex) {
                            buttonNavigationItem.selectedIcon
                        }else{buttonNavigationItem.unselectedIcon}, contentDescription = buttonNavigationItem.title
                    )
                }
            })
        }
    }
}


@Composable
fun VacationListItem(
    name: String,
    photoUrl: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable(onClick = onClick)
    ) {
        AsyncImage(
            model = photoUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(60.dp)
                .clip(CircleShape)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 16.dp)
        )
    }
}


@Preview
@Composable
fun DashboardPreview() {
    val navDummy = rememberNavController()
    Dashboard(navigation = navDummy)
}