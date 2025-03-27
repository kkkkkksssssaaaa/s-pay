package dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate

import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money

data class ExchangedRate(
    val base: Money,
    val target: Money
)