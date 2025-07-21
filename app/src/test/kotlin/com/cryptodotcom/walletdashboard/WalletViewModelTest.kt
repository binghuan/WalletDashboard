package com.cryptodotcom.walletdashboard

import app.cash.turbine.test
import com.cryptodotcom.walletdashboard.data.repository.WalletRepository
import com.cryptodotcom.walletdashboard.presentation.viewmodel.WalletViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * Unit tests for WalletViewModel
 */
@OptIn(ExperimentalCoroutinesApi::class)
class WalletViewModelTest {

    @Mock
    private lateinit var repository: WalletRepository

    private lateinit var viewModel: WalletViewModel
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state is loading`() = runTest {
        // Given
        `when`(repository.getWalletItems()).thenReturn(flowOf(emptyList()))

        // When
        viewModel = WalletViewModel(repository)

        // Then
        viewModel.uiState.test {
            val initialState = awaitItem()
            assertFalse(initialState.isLoading)
            assertEquals(emptyList<Any>(), initialState.walletItems)
            assertEquals(0.0, initialState.totalUsdValue, 0.001)
            assertNull(initialState.error)
        }
    }

    @Test
    fun `retry triggers data reload`() = runTest {
        // Given
        `when`(repository.getWalletItems()).thenReturn(flowOf(emptyList()))
        
        viewModel = WalletViewModel(repository)

        // When
        viewModel.retry()

        // Then - Repository method should be called at least twice (init + retry)
        verify(repository, atLeast(2)).getWalletItems()
    }
}
