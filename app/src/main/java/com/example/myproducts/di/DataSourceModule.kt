package com.example.lloydslearning.di

import com.example.myproducts.data.datasource.FetchProductDataSourceImpl
import com.example.myproducts.data.datasource.FetchProductDatasource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindUserDataSource(userDataSourceImpl: FetchProductDataSourceImpl): FetchProductDatasource
}