package com.example.giphy.di

import com.example.giphy.data.network.ApiFactory
import com.example.giphy.data.network.ApiService
import com.example.giphy.data.repository.GifRepositoryImpl
import com.example.giphy.domain.repository.GifRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindGifRepository(impl: GifRepositoryImpl): GifRepository

    companion object {

        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}