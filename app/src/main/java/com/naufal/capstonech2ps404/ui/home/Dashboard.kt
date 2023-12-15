package com.naufal.capstonech2ps404.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.naufal.capstonech2ps404.data.VacationRepository
import com.naufal.capstonech2ps404.viewmodel.VacationsViewModel
import com.naufal.capstonech2ps404.viewmodel.ViewModelFactory


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
                .background(Color.Gray)
        ) {

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