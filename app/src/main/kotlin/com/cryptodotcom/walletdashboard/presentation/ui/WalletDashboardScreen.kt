package com.cryptodotcom.walletdashboard.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cryptodotcom.walletdashboard.data.model.WalletItem
import com.cryptodotcom.walletdashboard.presentation.ui.components.TotalBalanceCard
import com.cryptodotcom.walletdashboard.presentation.ui.components.WalletItemCard
import com.cryptodotcom.walletdashboard.presentation.viewmodel.WalletViewModel
import kotlinx.serialization.InternalSerializationApi

@OptIn(InternalSerializationApi::class)
@Composable
fun WalletDashboardScreen(
    viewModel: WalletViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Text(
            text = "Crypto Wallet Dashboard",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Total Balance
        TotalBalanceCard(totalUsdValue = uiState.totalUsdValue)

        // Error handling
        uiState.error?.let { error ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                backgroundColor = MaterialTheme.colors.error
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = error,
                        color = MaterialTheme.colors.onError,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { viewModel.retry() },
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onError)
                    ) {
                        Text("Retry", color = MaterialTheme.colors.error)
                    }
                }
            }
        }

        // Wallet Items List
        if (uiState.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn {
                items(uiState.walletItems) { item ->
                    WalletItemCard(item = item)
                }
            }
        }
    }
}

@OptIn(InternalSerializationApi::class)
@Preview(showBackground = true)
@Composable
fun WalletDashboardScreenPreview() {
    MaterialTheme {
        // Create mock WalletItem data
        val mockBitcoin = WalletItem(
            currency = com.cryptodotcom.walletdashboard.data.model.Currency(
                coinId = "bitcoin",
                name = "Bitcoin",
                symbol = "BTC",
                tokenDecimal = 8,
                contractAddress = "",
                withdrawalEta = emptyList(),
                colorfulImageUrl = "",
                grayImageUrl = "",
                hasDepositAddressTag = false,
                minBalance = 0.0,
                blockchainSymbol = "BTC",
                tradingSymbol = "BTC",
                code = "BTC",
                explorer = "",
                isErc20 = false,
                gasLimit = 0,
                tokenDecimalValue = "100000000",
                displayDecimal = 8,
                supportsLegacyAddress = false,
                depositAddressTagName = "",
                depositAddressTagType = "",
                numConfirmationRequired = 6
            ), balance = 0.5, exchangeRateToUsd = 43000.0, usdValue = 21500.0
        )

        val mockEthereum = WalletItem(
            currency = com.cryptodotcom.walletdashboard.data.model.Currency(
                coinId = "ethereum",
                name = "Ethereum",
                symbol = "ETH",
                tokenDecimal = 18,
                contractAddress = "",
                withdrawalEta = emptyList(),
                colorfulImageUrl = "",
                grayImageUrl = "",
                hasDepositAddressTag = false,
                minBalance = 0.0,
                blockchainSymbol = "ETH",
                tradingSymbol = "ETH",
                code = "ETH",
                explorer = "",
                isErc20 = false,
                gasLimit = 21000,
                tokenDecimalValue = "1000000000000000000",
                displayDecimal = 6,
                supportsLegacyAddress = false,
                depositAddressTagName = "",
                depositAddressTagType = "",
                numConfirmationRequired = 12
            ), balance = 2.5, exchangeRateToUsd = 1680.0, usdValue = 4200.0
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Crypto Wallet Dashboard",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Use TotalBalanceCard component
            TotalBalanceCard(totalUsdValue = 25700.0)

            // Use actual WalletItemCard components
            WalletItemCard(item = mockBitcoin)
            WalletItemCard(item = mockEthereum)
        }
    }
}
