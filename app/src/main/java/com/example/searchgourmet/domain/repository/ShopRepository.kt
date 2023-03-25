package com.example.searchgourmet.domain.repository

import com.example.searchgourmet.data.remote.SearchShopResultDto

interface ShopRepository {

    suspend fun searchShops(queries: Map<String, String>): SearchShopResultDto

}
