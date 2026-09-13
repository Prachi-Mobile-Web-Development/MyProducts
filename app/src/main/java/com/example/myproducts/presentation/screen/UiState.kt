package com.example.myproducts.presentation.screen
sealed class UiState<out T>{
    object Loading: UiState<Nothing>()
    object Empty: UiState<Nothing>()
    data class Success<T>(val data:T): UiState<T>()
    data class Error<T>(val message:String): UiState<T>()

}