package com.example.searchgourmet.presentation.search_shops

import com.example.searchgourmet.domain.model.DetailShopInfo

data class SearchShopsState (
    val isLoading: Boolean = false,
    val shops: List<DetailShopInfo>? = null,
    val error: String? = null
        )