package com.example.searchgourmet.presentation

sealed class ScreenRoute(val route: String) {
    object SearchScreen: ScreenRoute("search_shops_screen")
    object DetailScreen: ScreenRoute("detail_shop_screen")
    object FavoriteScreen: ScreenRoute("favorite_shops_screen")
}