package com.example.myproducts.data.datasource

import com.example.myproducts.data.dto.ProductItemDto

interface FetchProductDatasource {
    suspend fun fetchProducts(): List<ProductItemDto>
}