package com.naufal.capstonech2ps404.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.naufal.capstonech2ps404.model.ButtonNavigationItem
import com.naufal.capstonech2ps404.style.IconsApp
import com.naufal.capstonech2ps404.style.backgroundColor
import com.naufal.capstonech2ps404.style.onSurface
import com.naufal.capstonech2ps404.style.primaryColor
import java.util.Collections

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FabDashboard() {
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    val item = listOf(
        ButtonNavigationItem(
            title = "Home",
            selectedIcon = painterResource(id = IconsApp.icCompas),
            unselectedIcon = painterResource(id = IconsApp.icCompas),
            hasNews = false
        ),
        ButtonNavigationItem(
            title = "Notification",
            selectedIcon = painterResource(id = IconsApp.icNotification),
            unselectedIcon = painterResource(id = IconsApp.icNotification),
            hasNews = false,
        ),
        ButtonNavigationItem(
            title = "Favorite",
            selectedIcon = painterResource(id = IconsApp.icFavorite),
            unselectedIcon = painterResource(id = IconsApp.icFavorite),
            hasNews = false
        )
    )
    NavigationBar(
        containerColor = backgroundColor,
        modifier = Modifier
            .fillMaxWidth().heightIn(min = 48.dp).height(71.dp)
            .padding(start = 44.dp, end = 16.dp)
            .border(width = 1.dp, color = primaryColor, shape = RoundedCornerShape(40.dp))
            .clip(shape = RoundedCornerShape(40.dp))
    ) {
        item.forEachIndexed { index, buttonNavigationItem ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = primaryColor,
                    unselectedIconColor = onSurface,
                    indicatorColor = backgroundColor
                ),
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
//                navController.navigate(item.title)
                },
                icon = {
                    BadgedBox(badge = {}, modifier = Modifier.background(backgroundColor)) {
                        Icon(
                            painter = if (index == selectedItemIndex) {
                                buttonNavigationItem.selectedIcon
                            } else {
                                buttonNavigationItem.unselectedIcon
                            }, contentDescription = buttonNavigationItem.title, modifier = Modifier.size(24.dp)
                        )
                    }
                })
        }
    }
}


@Preview
@Composable
fun PreviewButtonNav() {
    Scaffold(floatingActionButton = { FabDashboard() }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

        }
    }
}