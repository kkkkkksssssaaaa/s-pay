package dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.CurrencyType

data class ExchangeRateMap(
    private val map: MutableMap<CurrencyType, Double>
)