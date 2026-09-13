package com.example.myproducts.domain.repository

import com.example.myproducts.domain.model.Products
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun fetchProducts(): Flow<List<Products>>
}