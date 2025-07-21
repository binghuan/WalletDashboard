package com.cryptodotcom.walletdashboard.data.repository

import com.cryptodotcom.walletdashboard.data.datasource.LocalDataSource
import com.cryptodotcom.walletdashboard.data.model.WalletItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.serialization.InternalSerializationApi
import javax.inject.Inject
import javax.inject.Singleton

@OptIn(InternalSerializationApi::class)
@Singleton
class WalletRepository @Inject constructor(
    private val localDataSource: LocalDataSource
) {

    fun getWalletItems(): Flow<List<WalletItem>> {
        return combine(
            localDataSource.getCurrencies(),
            localDataSource.getExchangeRates(),
            localDataSource.getWalletBalance()
        ) { currencyResponse, exchangeResponse, walletResponse ->

            walletResponse.wallet.map { balance ->
                val currency =
                    currencyResponse.currencies.first { it.symbol == balance.currency }
                val exchangeRateTier =
                    exchangeResponse.tiers.first { it.fromCurrency == balance.currency && it.toCurrency == "USD" }
                val rate = exchangeRateTier.rates.first().rate.toDouble()

                WalletItem(
                    currency = currency,
                    balance = balance.amount,
                    exchangeRateToUsd = rate,
                    usdValue = balance.amount * rate
                )
            }
        }
    }

    fun getTotalUsdValue(): Flow<Double> {
        return getWalletItems().map { items ->
            items.sumOf { it.usdValue }
        }
    }
}
