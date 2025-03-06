package dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.CurrencyType

data class ExchangeRateMap(
    val baseAmount: Long,
    val baseCurrencyType: CurrencyType,
    private val map: Map<CurrencyType, Double>
) {
    fun find(targetCurrencyType: CurrencyType): Double {
        return map[targetCurrencyType] ?: throw IllegalArgumentException()
    }
}