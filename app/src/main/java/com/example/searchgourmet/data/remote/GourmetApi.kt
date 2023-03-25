package com.example.searchgourmet.data.remote

import retrofit2.http.GET
import retrofit2.http.QueryMap

interface GourmetApi {

    @GET ("/hotpepper/gourmet/v1")
    suspend fun getShops(
        @QueryMap queries: Map<String, String>
    ): SearchShopResultDto
}