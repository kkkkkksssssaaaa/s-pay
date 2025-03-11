package dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.Currency
import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.CurrencyType
import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class ExchangeRateCacheService {
    @Cacheable(
        value = ["exchangeRate"],
        key = "{#baseCurrency.type}"
    )
    fun getExchangeRate(
        baseCurrency: Currency,
        targetCurrency: Currency
    ): ExchangeRateMap {
        val rateMap = getExchangeRateMap(baseCurrency.type)
        val baseAmount = rateMap[targetCurrency.type] ?: throw IllegalArgumentException()

        return ExchangeRateMap(
            base = Money(
                amount = baseAmount,
                currency = baseCurrency
            ),
            map = rateMap
        )
    }

    // TODO: 환율 조회 openapi 호출
    private fun getExchangeRateMap(
        baseCurrencyType: CurrencyType
    ): Map<CurrencyType, Double> {
        val newMap: MutableMap<CurrencyType, Double> = mutableMapOf()

        CurrencyType.entries.map {
            newMap.put(it, 1000.0)
        }

        return newMap
    }
}