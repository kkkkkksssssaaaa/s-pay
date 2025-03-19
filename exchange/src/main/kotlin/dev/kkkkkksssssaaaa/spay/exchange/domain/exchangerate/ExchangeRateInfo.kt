package dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.Currency
import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money

data class ExchangeRateInfo(
    val base: Money,
    private val items: Set<Money>
) {
    fun find(targetCurrency: Currency): Money {
        return items.firstOrNull { it.currency == targetCurrency }
            ?.let {
                Money(
                    currency = it.currency,
                    value = it.value
                )
            } ?: throw IllegalArgumentException(
                "No exchange rate found for currency: ${targetCurrency.type}"
            )
    }
}