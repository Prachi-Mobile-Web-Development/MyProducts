package com.example.myproducts.data.datasource

import com.example.myproducts.data.dto.ProductItemDto
import com.example.myproducts.data.remote.ProductApiService
import jakarta.inject.Inject

class FetchProductDataSourceImpl @Inject constructor(private val productApiService: ProductApiService): FetchProductDatasource {
    override suspend fun fetchProducts(): List<ProductItemDto> {
       return productApiService.fetchProducts()
    }
}