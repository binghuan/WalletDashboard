package com.cryptodotcom.walletdashboard.data.model

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@InternalSerializationApi
@Serializable
data class WalletBalanceResponse(
    @SerialName("ok") val ok: Boolean,
    @SerialName("warning") val warning: String,
    @SerialName("wallet") val wallet: List<WalletBalance>
)

@InternalSerializationApi
@Serializable
data class WalletBalance(
    @SerialName("currency") val currency: String,
    @SerialName("amount") val amount: Double
)
