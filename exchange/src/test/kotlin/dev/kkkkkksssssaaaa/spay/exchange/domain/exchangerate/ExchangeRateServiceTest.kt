package dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.CurrencyType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Import
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@Import(ExchangeRateService::class)
class ExchangeRateServiceTest {
    @MockitoBean private lateinit var exchangeRateCacheService: ExchangeRateCacheService
    @Autowired private lateinit var exchangeRateService: ExchangeRateService

    private val mockExchangeRateMap = ExchangeRateMap(
        1000L,
        CurrencyType.KRW,
        mapOf(
            CurrencyType.KRW to 1000.0,
            CurrencyType.USD to 1448.5,
            CurrencyType.JPY to 966.6,
            CurrencyType.CNY to 199.8,
            CurrencyType.EUR to 1550.8
        )
    )

    @Nested
    @DisplayName("getExchangeRate")
    inner class GetExchangeRateTest {
        @Test
        fun `원화에서 달러를 환전할 수 있다`() {
            // given
            `when`(exchangeRateCacheService.getExchangeRate(CurrencyType.KRW, CurrencyType.USD))
                .then { mockExchangeRateMap }

            // when
            val exchangeRate = exchangeRateService.getExchangeRate(
                CurrencyType.KRW,
                CurrencyType.USD
            )

            // then
            assertEquals(1000, exchangeRate.baseAmount)
            assertEquals(1448.5, exchangeRate.targetAmount)
        }
    }
}