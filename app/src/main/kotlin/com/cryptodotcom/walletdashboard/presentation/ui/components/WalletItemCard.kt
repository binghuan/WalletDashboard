package com.cryptodotcom.walletdashboard.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cryptodotcom.walletdashboard.data.model.Currency
import com.cryptodotcom.walletdashboard.data.model.WalletItem
import kotlinx.serialization.InternalSerializationApi

@OptIn(InternalSerializationApi::class)
@Composable
fun WalletItemCard(item: WalletItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = item.currency.symbol,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = item.currency.name,
                    style = MaterialTheme.typography.body2,
                    color = Color.Gray
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "${
                        String.format(
                            "%.6f", item.balance
                        )
                    } ${item.currency.symbol}",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "$${String.format("%.2f", item.usdValue)}",
                    style = MaterialTheme.typography.body2,
                    color = Color.Gray
                )
            }
        }
    }
}

@OptIn(InternalSerializationApi::class)
@Preview(showBackground = true)
@Composable
fun WalletItemCardBitcoinPreview() {
    MaterialTheme {
        val mockBitcoin = WalletItem(
            currency = Currency(
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
        WalletItemCard(item = mockBitcoin)
    }
}

@OptIn(InternalSerializationApi::class)
@Preview(showBackground = true)
@Composable
fun WalletItemCardEthereumPreview() {
    MaterialTheme {
        val mockEthereum = WalletItem(
            currency = Currency(
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
        WalletItemCard(item = mockEthereum)
    }
}

@OptIn(InternalSerializationApi::class)
@Preview(showBackground = true)
@Composable
fun WalletItemCardUSDTPreview() {
    MaterialTheme {
        val mockUSDT = WalletItem(
            currency = Currency(
                coinId = "tether",
                name = "Tether",
                symbol = "USDT",
                tokenDecimal = 6,
                contractAddress = "0xdAC17F958D2ee523a2206206994597C13D831ec7",
                withdrawalEta = emptyList(),
                colorfulImageUrl = "",
                grayImageUrl = "",
                hasDepositAddressTag = false,
                minBalance = 0.0,
                blockchainSymbol = "USDT",
                tradingSymbol = "USDT",
                code = "USDT",
                explorer = "",
                isErc20 = true,
                gasLimit = 21000,
                tokenDecimalValue = "1000000",
                displayDecimal = 2,
                supportsLegacyAddress = false,
                depositAddressTagName = "",
                depositAddressTagType = "",
                numConfirmationRequired = 12
            ), balance = 1000.0, exchangeRateToUsd = 1.0, usdValue = 1000.0
        )
        WalletItemCard(item = mockUSDT)
    }
}
