package dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.Currency
import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.CurrencyType
import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.impl.*
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
    ): ExchangeRateInfo {
        val exchangeRate = getExchangeRate(baseCurrency.type)
        val base = exchangeRate.firstOrNull { it.currency == baseCurrency }
            ?: throw IllegalArgumentException(
                "No exchange rate found for currency: ${baseCurrency.type}"
            )

        return ExchangeRateInfo(
            base = base,
            items = exchangeRate
        )
    }

    // TODO: 환율 조회 openapi 호출
    private fun getExchangeRate(
        baseCurrencyType: CurrencyType
    ): Set<Money> {
        return setOf(
            Money(
                currency = Won(),
                amount = 1000.0
            ),
            Money(
                currency = Dollar(),
                amount = 1448.5
            ),
            Money(
                currency = Yen(),
                amount = 966.6
            ),
            Money(
                currency = Yuan(),
                amount = 199.8
            ),
            Money(
                currency = Euro(),
                amount = 1550.8
            )
        )
    }
}