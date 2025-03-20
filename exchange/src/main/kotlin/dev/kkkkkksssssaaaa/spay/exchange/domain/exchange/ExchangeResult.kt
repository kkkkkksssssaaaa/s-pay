package dev.kkkkkksssssaaaa.spay.exchange.domain.exchange

import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money

data class ExchangeResult(
    val base: Money,
    val target: Money
)
