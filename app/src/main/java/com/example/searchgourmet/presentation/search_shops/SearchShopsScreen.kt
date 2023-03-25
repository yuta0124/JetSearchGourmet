package com.example.searchgourmet.presentation.search_shops

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun SearchShopsScreen(
    navController: NavController,
    viewModel: SearchShopsViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            state.isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            !state.error.isNullOrBlank() -> {
                Text(text = state.error)
            }
            else -> {
                Text(text = state.shops.toString())
            }
        }
    }
}