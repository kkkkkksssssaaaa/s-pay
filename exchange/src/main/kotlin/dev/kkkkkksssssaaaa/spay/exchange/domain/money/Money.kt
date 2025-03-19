package dev.kkkkkksssssaaaa.spay.exchange.domain.money

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.Currency

class Money(
    val currency: Currency,
    val value: Double
) {
    operator fun times(targetMoney: Money): Money {
        if (this.currency != targetMoney.currency) {
            throw UnsupportedOperationException(
                "Unable to calculate because the currency types do not match."
            )
        }

        return Money(
            this.currency,
            this.value * targetMoney.value
        )
    }

    operator fun compareTo(value: Double): Int {
        return this.value.compareTo(value)
    }
}