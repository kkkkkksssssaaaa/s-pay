package dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.CurrencyType
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class ExchangeRateCacheService {
    @Cacheable("exchangeRate")
    fun getExchangeRate(
        baseCurrency: CurrencyType,
        targetCurrency: CurrencyType
    ): ExchangeRateMap {
        val newMap: MutableMap<CurrencyType, Double> = mutableMapOf()

        CurrencyType.entries.map {
            newMap.put(it, 1.0)
        }

        return ExchangeRateMap(newMap)
    }
}