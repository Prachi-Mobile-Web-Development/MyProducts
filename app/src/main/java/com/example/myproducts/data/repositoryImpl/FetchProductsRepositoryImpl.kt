package com.example.myproducts.data.repositoryImpl

import com.example.myproducts.data.datasource.FetchProductDatasource
import com.example.myproducts.domain.model.Products
import com.example.myproducts.domain.model.toDomain
import com.example.myproducts.domain.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchProductsRepositoryImpl @Inject constructor(private val fetchProductDatasource: FetchProductDatasource): ProductRepository {
    override fun fetchProducts(): Flow<List<Products>> =flow{
            val data = fetchProductDatasource.fetchProducts()
            val response = data.map { it.toDomain() }
            emit(response)}
            .flowOn(Dispatchers.IO)
    }

