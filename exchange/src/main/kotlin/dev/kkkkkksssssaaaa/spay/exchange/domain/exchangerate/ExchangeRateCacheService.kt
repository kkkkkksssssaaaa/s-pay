package dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.CurrencyType
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class ExchangeRateCacheService {
    @Cacheable(
        value = ["exchangeRate"],
        key = "{#baseCurrency.name()}"
    )
    fun getExchangeRate(
        baseCurrency: CurrencyType,
        targetCurrency: CurrencyType
    ): ExchangeRateMap {
        val rateMap = getExchangeRateMap(baseCurrency)

        return ExchangeRateMap(
            baseAmount = rateMap.entries.first {
                it.key == baseCurrency
            }.value.toLong(),
            rateMap
        )
    }

    // TODO: 환율 조회 openapi 호출
    private fun getExchangeRateMap(
        baseCurrency: CurrencyType
    ): Map<CurrencyType, Double> {
        val newMap: MutableMap<CurrencyType, Double> = mutableMapOf()

        CurrencyType.entries.map {
            newMap.put(it, 1000.0)
        }

        return newMap
    }
}