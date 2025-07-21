package com.cryptodotcom.walletdashboard.data.model

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@InternalSerializationApi
@Serializable
data class CurrenciesResponse(
    @SerialName("currencies") val currencies: List<Currency>,
    @SerialName("total") val total: Int,
    @SerialName("ok") val ok: Boolean
)

@InternalSerializationApi
@Serializable
data class Currency(
    @SerialName("coin_id") val coinId: String,
    @SerialName("name") val name: String,
    @SerialName("symbol") val symbol: String,
    @SerialName("token_decimal") val tokenDecimal: Int,
    @SerialName("contract_address") val contractAddress: String,
    @SerialName("withdrawal_eta") val withdrawalEta: List<String>,
    @SerialName("colorful_image_url") val colorfulImageUrl: String,
    @SerialName("gray_image_url") val grayImageUrl: String,
    @SerialName("has_deposit_address_tag") val hasDepositAddressTag: Boolean,
    @SerialName("min_balance") val minBalance: Double,
    @SerialName("blockchain_symbol") val blockchainSymbol: String,
    @SerialName("trading_symbol") val tradingSymbol: String,
    @SerialName("code") val code: String,
    @SerialName("explorer") val explorer: String,
    @SerialName("is_erc20") val isErc20: Boolean,
    @SerialName("gas_limit") val gasLimit: Int,
    @SerialName("token_decimal_value") val tokenDecimalValue: String,
    @SerialName("display_decimal") val displayDecimal: Int,
    @SerialName("supports_legacy_address") val supportsLegacyAddress: Boolean,
    @SerialName("deposit_address_tag_name") val depositAddressTagName: String,
    @SerialName("deposit_address_tag_type") val depositAddressTagType: String,
    @SerialName("num_confirmation_required") val numConfirmationRequired: Int
)
