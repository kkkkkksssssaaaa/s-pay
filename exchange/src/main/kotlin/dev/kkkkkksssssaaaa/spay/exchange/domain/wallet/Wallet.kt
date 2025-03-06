package dev.kkkkkksssssaaaa.spay.exchange.domain.wallet

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.Currency

data class Wallet(
    val amount: Int,
    val baseCurrency: Currency
) {
}