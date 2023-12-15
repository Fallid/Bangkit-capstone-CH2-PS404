package com.naufal.capstonech2ps404.ui.home

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.naufal.capstonech2ps404.R
import com.naufal.capstonech2ps404.style.backgroundColor
import com.naufal.capstonech2ps404.style.primaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarLayout(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier

) {
    SearchBar(
        query = query,
        onQueryChange = onQueryChange,
        onSearch = {},
        active = false,
        onActiveChange = {},
        colors = SearchBarDefaults.colors(
            containerColor = backgroundColor
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = colorResource(id = R.color.primaryColor)
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Outlined.Settings,
                contentDescription = "Setting",
                tint = colorResource(
                    id = R.color.primaryColor
                )
            )
        },
        placeholder = {
            Text(stringResource(R.string.search_hero))
        },
        shape = SearchBarDefaults.fullScreenShape,
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth().height(54.dp)
            .heightIn(min = 45.dp)
            .border(
                width = 1.dp,
                color = primaryColor,
                shape = RoundedCornerShape(40.dp)
            )
    ) {
    }
}