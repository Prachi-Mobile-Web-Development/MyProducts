package com.example.myproducts.data.remote

import com.example.myproducts.data.dto.ProductItemDto
import retrofit2.http.GET

interface ProductApiService {
    @GET("866592d4df655060f42c")
    suspend fun fetchProducts():List<ProductItemDto>
}