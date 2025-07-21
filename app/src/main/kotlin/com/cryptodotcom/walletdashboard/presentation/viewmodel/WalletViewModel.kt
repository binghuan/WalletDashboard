package com.cryptodotcom.walletdashboard.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cryptodotcom.walletdashboard.data.model.WalletItem
import com.cryptodotcom.walletdashboard.data.repository.WalletRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

data class WalletUiState(
    val isLoading: Boolean = false,
    val walletItems: List<WalletItem> = emptyList(),
    val totalUsdValue: Double = 0.0,
    val error: String? = null
)

@HiltViewModel
class WalletViewModel @Inject constructor(
    private val repository: WalletRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(WalletUiState(isLoading = true))
    val uiState: StateFlow<WalletUiState> = _uiState.asStateFlow()

    init {
        loadWalletData()
    }

    private fun loadWalletData() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)

            repository.getWalletItems().catch { error ->
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = error.message ?: "Unknown error occurred"
                )
            }.collect { items ->
                val totalUsd = items.sumOf { it.usdValue }
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    walletItems = items,
                    totalUsdValue = totalUsd,
                    error = null
                )
            }
        }
    }

    fun retry() {
        loadWalletData()
    }
}
