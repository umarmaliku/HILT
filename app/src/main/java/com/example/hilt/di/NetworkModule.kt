package com.example.hilt.di

import com.example.hilt.data.remote.api.PhotoApiService
import com.example.hilt.data.remote.api.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Provides
    @Singleton
    fun providePostApiService(): PhotoApiService{
        return retrofitClient.photoApiService
    }
}