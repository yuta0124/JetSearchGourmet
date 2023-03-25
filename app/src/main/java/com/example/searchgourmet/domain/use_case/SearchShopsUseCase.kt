package com.example.searchgourmet.domain.use_case

import android.provider.ContactsContract.Contacts.Photo
import com.example.searchgourmet.data.remote.toShops
import com.example.searchgourmet.domain.model.DetailShopInfo
import com.example.searchgourmet.domain.repository.ShopRepository
import com.example.searchgourmet.utils.NetWorkResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchShopsUseCase @Inject constructor(
    private val repository: ShopRepository
) {

    operator fun invoke(queries: Map<String, String>): Flow<NetWorkResponse<List<DetailShopInfo>>> = flow {
        emit(NetWorkResponse.Loading<List<DetailShopInfo>>())

        try {
            val shops = repository.searchShops(queries = queries).toShops()
            emit(NetWorkResponse.Success<List<DetailShopInfo>>(data = shops))
        }catch (e: Exception) {
            emit(NetWorkResponse.Failure<List<DetailShopInfo>>(error = e.message.toString()))
        }
    }
}