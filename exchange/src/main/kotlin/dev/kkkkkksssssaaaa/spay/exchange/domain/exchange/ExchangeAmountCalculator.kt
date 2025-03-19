package dev.kkkkkksssssaaaa.spay.exchange.domain.exchange

import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money

class ExchangeAmountCalculator {
    companion object {
        fun doCalculate(
            request: ExchangeCalculateRequest
        ): Money {
            val result = request.exchangeRate.target * request.targetAmount

            if (result <= 0.0) {
                throw IllegalArgumentException("Invalid request for this exchange")
            }

            return Money(
                currency = request.exchangeRate.target.currency,
                value = result.value
            )
        }
    }
}
