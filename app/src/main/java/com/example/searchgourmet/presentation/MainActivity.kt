package com.example.searchgourmet.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.searchgourmet.presentation.detail_shop.DetailShopScreen
import com.example.searchgourmet.presentation.favorite_shops.FavoriteShopsScreen
import com.example.searchgourmet.presentation.search_shops.SearchShopsScreen
import com.example.searchgourmet.presentation.ui.theme.SearchGourmetTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchGourmetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = ScreenRoute.SearchScreen.route,
                        builder = {
                            //店検索画面
                            composable(route = ScreenRoute.SearchScreen.route) {
                                SearchShopsScreen(navController = navController)
                            }
                            //店舗詳細画面
                            composable(route = ScreenRoute.DetailScreen.route + "/{shopInfo}") {
                                DetailShopScreen()
                            }
                            //お気に入り店舗一覧画面
                            composable(route = ScreenRoute.FavoriteScreen.route) {
                                FavoriteShopsScreen(navController = navController)
                            }
                        }
                    )
                }
            }
        }
    }
}

