package com.example.myproducts.domain.usecase

import com.example.myproducts.domain.model.Products
import com.example.myproducts.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductUseCase @Inject constructor(private val productRepository: ProductRepository) {
    operator fun invoke (): Flow<List<Products>>
            =productRepository.fetchProducts()
}
