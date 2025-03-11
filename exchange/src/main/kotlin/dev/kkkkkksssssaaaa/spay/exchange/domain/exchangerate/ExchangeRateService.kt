package dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.Currency
import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money
import org.springframework.stereotype.Service

@Service
class ExchangeRateService(
    private val exchangeRateCacheService: ExchangeRateCacheService
) {
    fun getExchangeRate(
        baseCurrency: Currency,
        targetCurrency: Currency
    ): ExchangeRate {
        val exchangeRateMap = exchangeRateCacheService.getExchangeRate(
            baseCurrency,
            targetCurrency
        )

        return ExchangeRate(
            base = Money(
                currency = baseCurrency,
                amount = exchangeRateMap.base.amount,
            ),
            target = Money(
                currency = targetCurrency,
                amount = exchangeRateMap.find(targetCurrency)
            )
        )
    }
}