package com.example.searchgourmet.data.remote


import com.example.searchgourmet.domain.model.DetailShopInfo
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchShopResultDto(
    val results: Results?
)

fun SearchShopResultDto.toShops(): List<DetailShopInfo> {
    var shops = mutableListOf<DetailShopInfo>()
    results?.shop?.let {
        it.map { shop ->
            val detailShopInfo = DetailShopInfo(
                name = shop?.name,
                image = shop?.photo?.pc?.m,
                catch = shop?.catch,
                address = shop?.address,
                access = shop?.access,
                station = shop?.stationName,
                genre = shop?.genre?.name,
                open = shop?.open
            )
        shops.add(detailShopInfo)
        }
    }
    return shops
}