package com.example.lloydslearning.di

import com.example.myproducts.data.repositoryImpl.FetchProductsRepositoryImpl
import com.example.myproducts.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindUserRepositoryImpl(userRepositoryImpl: FetchProductsRepositoryImpl): ProductRepository
}