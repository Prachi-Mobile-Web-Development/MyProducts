package com.example.myproducts.presentation.screen

import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ShoppingCart

import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.myproducts.domain.model.Products
import com.example.myproducts.presentation.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    viewModel: ProductViewModel,
    onProfileClick: () -> Unit,
    onCartClick: () -> Unit,
    onProductClick: (productId: String) -> Unit
) {
    val productsState by viewModel.productStateFlow.collectAsState()


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Products") },
                actions = {
                    IconButton(onClick = onProfileClick) {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = "Profile",
                            modifier = Modifier.size(28.dp)
                        )
                    }
                    IconButton(onClick = onCartClick) {
                            Icon(
                                imageVector = Icons.Filled.ShoppingCart,
                                contentDescription = "Cart",
                                modifier = Modifier.size(26.dp)
                            )
                        }

                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (val state = productsState) {
                is UiState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                is UiState.Empty -> {
                    Text(
                        text = "No products found",
                        modifier = Modifier.align(Alignment.Center),
                        color = Color.Gray
                    )
                }
                is UiState.Error -> {
                    Column(
                        modifier = Modifier.align(Alignment.Center),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = state.message, color = Color.Red)
                        Spacer(modifier = Modifier.height(8.dp))

                    }
                }
                is UiState.Success -> {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(state.data) { product ->
                            ProductRow(
                                product = product,
                                onClick = { onProductClick(product.id.toString()) }
                            )
                            Divider()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProductRow(
    product: Products,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(12.dp)
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = product.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.LightGray)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = product.name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = product.description,
                fontSize = 13.sp,
                color = Color.Gray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "₹${product.price.toInt()}",
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
    }
}