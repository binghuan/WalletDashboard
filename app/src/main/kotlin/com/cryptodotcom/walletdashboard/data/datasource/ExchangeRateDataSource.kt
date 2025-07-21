package com.cryptodotcom.walletdashboard.data.datasource

import com.cryptodotcom.walletdashboard.data.model.ExchangeRate

class ExchangeRateDataSource {
    
    fun getExchangeRates(): List<ExchangeRate> {
        return listOf(
            ExchangeRate(
                amount = "1",
                rate = "10603.9"
            ),
            ExchangeRate(
                amount = "1",
                rate = "450.0"
            ),
            ExchangeRate(
                amount = "1",
                rate = "0.12"
            )
        )
    }
}
