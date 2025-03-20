package dev.kkkkkksssssaaaa.spay.exchange.domain.exchange

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.Currency
import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money
import dev.kkkkkksssssaaaa.spay.exchange.domain.wallet.Wallet

data class ExchangeRequest(
    val wallet: Wallet,
    val targetCurrency: Currency,
    val targetAmount: Money,
    val baseCurrency: Currency,
)