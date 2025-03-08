package dev.kkkkkksssssaaaa.spay.exchange.domain.wallet

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.CurrencyType

data class Wallet(
    val id: Long,
    val amount: Int,
    val baseCurrency: CurrencyType
) {
}