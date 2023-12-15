package com.naufal.capstonech2ps404.ui.home

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.naufal.capstonech2ps404.model.ButtonNavigationItem

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
    NavigationBar(contentColor = Color.Blue) {
        item.forEachIndexed { index, buttonNavigationItem ->
            NavigationBarItem(selected = selectedItemIndex == index, onClick = {
                selectedItemIndex = index
//                navController.navigate(item.title)
            }, icon = {
                BadgedBox(badge = {}) {
                    Icon(
                        imageVector = if (index == selectedItemIndex) {
                            buttonNavigationItem.selectedIcon
                        } else {
                            buttonNavigationItem.unselectedIcon
                        }, contentDescription = buttonNavigationItem.title
                    )
                }
            })
        }
    }
}