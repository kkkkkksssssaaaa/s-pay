package dev.kkkkkksssssaaaa.spay.exchange.domain.exchange

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.Currency
import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money

data class ExchangeRequest(
    val walletId: Long,
    val targetCurrency: Currency,
    val targetAmount: Money,
    val baseCurrency: Currency,
)