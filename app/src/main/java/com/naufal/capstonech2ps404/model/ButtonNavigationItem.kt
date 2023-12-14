package com.naufal.capstonech2ps404.model

import androidx.compose.ui.graphics.vector.ImageVector

data class ButtonNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)