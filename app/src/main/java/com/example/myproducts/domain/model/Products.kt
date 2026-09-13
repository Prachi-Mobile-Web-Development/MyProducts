package com.example.myproducts.domain.model

import com.example.myproducts.data.dto.ProductItemDto

data class Products(
    val id: Int,
    val name: String,
    val price: Int,
    val imageUrl: String,
    val description: String
)
fun ProductItemDto.toDomain(): Products= Products(
   id=this.id,
    name=this.name,
    price=this.price,
    imageUrl=this.imageUrl,
    description=this.description
)