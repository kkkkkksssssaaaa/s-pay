package dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.CurrencyType
import org.springframework.stereotype.Service

@Service
class ExchangeRateService(
    private val exchangeRateCacheService: ExchangeRateCacheService
) {
    fun getExchangeRate(
        baseCurrencyType: CurrencyType,
        targetCurrencyType: CurrencyType
    ): ExchangeRate {
        val exchangeRateMap = exchangeRateCacheService.getExchangeRate(
            baseCurrencyType,
            targetCurrencyType
        )

        return ExchangeRate(
            baseAmount = exchangeRateMap.baseAmount,
            targetAmount = exchangeRateMap.find(targetCurrencyType)
        )
    }
}