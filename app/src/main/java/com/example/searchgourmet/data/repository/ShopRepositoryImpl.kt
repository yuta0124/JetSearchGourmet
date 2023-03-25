package com.example.searchgourmet.data.repository

import com.example.searchgourmet.data.remote.GourmetApi
import com.example.searchgourmet.data.remote.SearchShopResultDto
import com.example.searchgourmet.domain.repository.ShopRepository

class ShopRepositoryImpl(
    private val api: GourmetApi
    ) : ShopRepository {

    override suspend fun searchShops(queries: Map<String, String>): SearchShopResultDto {
        return api.getShops(queries)
    }
}
