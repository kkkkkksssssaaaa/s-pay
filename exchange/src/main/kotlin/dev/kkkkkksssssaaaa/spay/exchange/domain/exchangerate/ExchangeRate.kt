package dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate

import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money

data class ExchangeRate(
    val base: Money,
    val target: Money
)