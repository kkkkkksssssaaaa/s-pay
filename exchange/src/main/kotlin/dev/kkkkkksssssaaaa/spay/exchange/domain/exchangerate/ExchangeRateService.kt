package dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.Currency
import org.springframework.stereotype.Service

@Service
class ExchangeRateService(
    private val exchangeRateCacheService: ExchangeRateCacheService
) {
    fun getExchangeRate(
        baseCurrency: Currency,
        targetCurrency: Currency
    ): ExchangedRate {
        val exchangeRate = exchangeRateCacheService.getExchangeRate(
            baseCurrency,
            targetCurrency
        )

        return ExchangedRate(
            base = exchangeRate.base,
            target = exchangeRate.find(targetCurrency)
        )
    }
}