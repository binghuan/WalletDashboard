package com.cryptodotcom.walletdashboard.data.model

import kotlinx.serialization.InternalSerializationApi

data class WalletItem @OptIn(InternalSerializationApi::class) constructor(
    val currency: Currency,
    val balance: Double,
    val exchangeRateToUsd: Double,
    val usdValue: Double
) {
    @OptIn(InternalSerializationApi::class)
    val formattedBalance: String
        get() = String.format("%.${currency.displayDecimal}f", balance)

    val formattedUsdValue: String
        get() = String.format("$%.2f", usdValue)
}
