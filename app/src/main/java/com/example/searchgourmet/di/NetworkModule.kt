package com.example.searchgourmet.di

import com.example.searchgourmet.data.remote.GourmetApi
import com.example.searchgourmet.data.repository.ShopRepositoryImpl
import com.example.searchgourmet.domain.repository.ShopRepository
import com.example.searchgourmet.utils.Constants.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideGourmetApi(): GourmetApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(
                Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            )).build().create(GourmetApi::class.java)
    }

    @Provides
    @Singleton
    fun provideShopRepository(api: GourmetApi): ShopRepository {
        return ShopRepositoryImpl(api)
    }
}