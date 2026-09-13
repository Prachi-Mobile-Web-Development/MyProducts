package com.example.lloydslearning.di

import com.example.myproducts.data.remote.ProductApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    val BASE_URL="https://api.npoint.io/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
       return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ProductApiService
            = retrofit.create(ProductApiService::class.java)
}