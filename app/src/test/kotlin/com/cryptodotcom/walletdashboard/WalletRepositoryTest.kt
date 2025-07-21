package com.cryptodotcom.walletdashboard

import com.cryptodotcom.walletdashboard.data.datasource.LocalDataSource
import com.cryptodotcom.walletdashboard.data.repository.WalletRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.InternalSerializationApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Unit tests for WalletRepository
 */
@OptIn(InternalSerializationApi::class)
class WalletRepositoryTest {

    private lateinit var repository: WalletRepository
    private lateinit var dataSource: LocalDataSource

    @Before
    fun setUp() {
        dataSource = LocalDataSource()
        repository = WalletRepository(dataSource)
    }

    @Test
    fun `getWalletItems returns correct wallet items`() = runTest {
        // When
        val walletItems = repository.getWalletItems().first()

        // Then
        assertEquals(3, walletItems.size)

        val btcItem = walletItems.find { it.currency.symbol == "BTC" }
        assertNotNull(btcItem)
        assertEquals(1.4, btcItem!!.balance, 0.001)
        assertEquals(10603.9, btcItem.exchangeRateToUsd, 0.001)

        val ethItem = walletItems.find { it.currency.symbol == "ETH" }
        assertNotNull(ethItem)
        assertEquals(20.3, ethItem!!.balance, 0.001)
        assertEquals(340.21, ethItem.exchangeRateToUsd, 0.001)

        val croItem = walletItems.find { it.currency.symbol == "CRO" }
        assertNotNull(croItem)
        assertEquals(259.1, croItem!!.balance, 0.001)
        assertEquals(0.147268, croItem.exchangeRateToUsd, 0.001)
    }

    @Test
    fun `getTotalUsdValue returns correct total`() = runTest {
        // When
        val totalValue = repository.getTotalUsdValue().first()

        // Then
        // BTC: 1.4 * 10603.9 = 14845.46
        // ETH: 20.3 * 340.21 = 6906.263
        // CRO: 259.1 * 0.147268 = 38.160025
        val expectedTotal = 14845.46 + 6906.263 + 38.160025
        assertEquals(expectedTotal, totalValue, 0.01)
    }

    @Test
    fun `wallet item usd value calculation is correct`() = runTest {
        // When
        val walletItems = repository.getWalletItems().first()
        val btcItem = walletItems.find { it.currency.symbol == "BTC" }

        // Then
        assertNotNull(btcItem)
        val expectedUsdValue = 1.4 * 10603.9
        assertEquals(expectedUsdValue, btcItem!!.usdValue, 0.001)
    }
}
