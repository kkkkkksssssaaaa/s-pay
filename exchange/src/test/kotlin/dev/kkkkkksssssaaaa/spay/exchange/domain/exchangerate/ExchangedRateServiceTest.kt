package dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.impl.*
import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money
import org.junit.jupiter.api.Assertions.assertEquals
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
class ExchangedRateServiceTest {
    @MockitoBean private lateinit var exchangeRateCacheService: ExchangeRateCacheService
    @Autowired private lateinit var exchangeRateService: ExchangeRateService

    private val mockExchangeRateInfo = ExchangeRateInfo(
        Money(
            currency = Won(),
            amount = 1000.0
        ),
        setOf(
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
    )

    @Nested
    @DisplayName("getExchangeRate")
    inner class GetExchangedRateTest {
        @Test
        fun `원화를 기준으로 현재 달러 환율을 조회할 수 있다`() {
            // given
            `when`(exchangeRateCacheService.getExchangeRate(Won(), Dollar()))
                .thenReturn(mockExchangeRateInfo)

            // when
            val exchangeRate: ExchangedRate = exchangeRateService.getExchangeRate(
                Won(),
                Dollar()
            )

            // then
            assertEquals(1000.0, exchangeRate.base.amount)
            assertEquals(1448.5, exchangeRate.target.amount)
        }
    }
}