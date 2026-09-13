package com.example.myproducts.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myproducts.domain.model.Products
import com.example.myproducts.domain.usecase.ProductUseCase
import com.example.myproducts.presentation.screen.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productUseCase: ProductUseCase): ViewModel() {
    val productStateFlow: StateFlow<UiState<List<Products>>>
    =productUseCase().map { data->if(data.isEmpty())
        UiState.Empty
        else
        UiState.Success(data)
    }.onStart { emit(UiState.Loading) }.catch { e-> emit(UiState.Error(e.message?:"UnKnown Error")) }.stateIn(viewModelScope,
    SharingStarted.WhileSubscribed(5000), UiState.Loading)

}







