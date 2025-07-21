package com.cryptodotcom.walletdashboard.data.model

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@InternalSerializationApi
@Serializable
data class ExchangeRatesResponse(
    @SerialName("ok") val ok: Boolean,
    @SerialName("warning") val warning: String,
    @SerialName("tiers") val tiers: List<ExchangeRateTier>
)

@InternalSerializationApi
@Serializable
data class ExchangeRateTier(
    @SerialName("from_currency") val fromCurrency: String,
    @SerialName("to_currency") val toCurrency: String,
    @SerialName("rates") val rates: List<ExchangeRate>,
    @SerialName("time_stamp") val timeStamp: Long
)

@Serializable
data class ExchangeRate(
    @SerialName("amount") val amount: String,
    @SerialName("rate") val rate: String
)
