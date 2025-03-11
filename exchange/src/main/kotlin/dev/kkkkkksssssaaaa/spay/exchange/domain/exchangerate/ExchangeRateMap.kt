package dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.Currency
import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.CurrencyType
import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money

data class ExchangeRateMap(
    val base: Money,
    private val map: Map<CurrencyType, Double>
) {
    fun find(targetCurrency: Currency): Double {
        return map[targetCurrency.type] ?: throw IllegalArgumentException()
    }
}