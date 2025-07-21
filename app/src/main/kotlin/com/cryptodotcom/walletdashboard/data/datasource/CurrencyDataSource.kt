package com.cryptodotcom.walletdashboard.data.datasource

import com.cryptodotcom.walletdashboard.data.model.Currency
import kotlinx.serialization.InternalSerializationApi

@OptIn(InternalSerializationApi::class)
class CurrencyDataSource {
    
    fun getCurrencies(): List<Currency> {
        return listOf(
            Currency(
                coinId = "bitcoin",
                name = "Bitcoin",
                symbol = "BTC",
                tokenDecimal = 8,
                contractAddress = "",
                withdrawalEta = emptyList(),
                colorfulImageUrl = "https://example.com/btc.png",
                grayImageUrl = "https://example.com/btc_gray.png",
                hasDepositAddressTag = false,
                minBalance = 0.0,
                blockchainSymbol = "BTC",
                tradingSymbol = "BTC",
                code = "BTC",
                explorer = "https://blockchain.info/",
                isErc20 = false,
                gasLimit = 0,
                tokenDecimalValue = "100000000",
                displayDecimal = 8,
                supportsLegacyAddress = true,
                depositAddressTagName = "",
                depositAddressTagType = "",
                numConfirmationRequired = 6
            ),
            Currency(
                coinId = "ethereum",
                name = "Ethereum",
                symbol = "ETH",
                tokenDecimal = 18,
                contractAddress = "",
                withdrawalEta = emptyList(),
                colorfulImageUrl = "https://example.com/eth.png",
                grayImageUrl = "https://example.com/eth_gray.png",
                hasDepositAddressTag = false,
                minBalance = 0.0,
                blockchainSymbol = "ETH",
                tradingSymbol = "ETH",
                code = "ETH",
                explorer = "https://etherscan.io/",
                isErc20 = false,
                gasLimit = 21000,
                tokenDecimalValue = "1000000000000000000",
                displayDecimal = 18,
                supportsLegacyAddress = false,
                depositAddressTagName = "",
                depositAddressTagType = "",
                numConfirmationRequired = 12
            ),
            Currency(
                coinId = "crypto-com-chain",
                name = "Crypto.com Coin",
                symbol = "CRO",
                tokenDecimal = 8,
                contractAddress = "",
                withdrawalEta = emptyList(),
                colorfulImageUrl = "https://example.com/cro.png",
                grayImageUrl = "https://example.com/cro_gray.png",
                hasDepositAddressTag = false,
                minBalance = 0.0,
                blockchainSymbol = "CRO",
                tradingSymbol = "CRO",
                code = "CRO",
                explorer = "https://crypto.org/explorer/",
                isErc20 = false,
                gasLimit = 0,
                tokenDecimalValue = "100000000",
                displayDecimal = 8,
                supportsLegacyAddress = false,
                depositAddressTagName = "",
                depositAddressTagType = "",
                numConfirmationRequired = 1
            )
        )
    }
}
