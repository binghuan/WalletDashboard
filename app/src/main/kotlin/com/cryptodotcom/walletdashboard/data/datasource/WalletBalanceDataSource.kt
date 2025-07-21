package com.cryptodotcom.walletdashboard.data.datasource

import com.cryptodotcom.walletdashboard.data.model.WalletBalance
import kotlinx.serialization.InternalSerializationApi

@OptIn(InternalSerializationApi::class)
class WalletBalanceDataSource {
    
    fun getWalletBalances(): List<WalletBalance> {
        return listOf(
            WalletBalance(
                currency = "BTC",
                amount = 1.4
            ),
            WalletBalance(
                currency = "ETH",
                amount = 5.5
            ),
            WalletBalance(
                currency = "CRO", 
                amount = 12000.0
            )
        )
    }
}
