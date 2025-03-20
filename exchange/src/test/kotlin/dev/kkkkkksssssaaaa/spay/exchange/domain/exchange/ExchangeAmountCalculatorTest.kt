package dev.kkkkkksssssaaaa.spay.exchange.domain.exchange

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.impl.Dollar
import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.impl.Won
import dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate.ExchangedRate
import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ExchangeAmountCalculatorTest {
    @Nested
    @DisplayName("달러를 환전할 때")
    inner class DollarExchangeTest {
        /**
         * 환율 정보
         *
         * 원화 1천원 기준 1달러에 1450원
         * */
        private val mockExchangedRate = ExchangedRate(
            base = Money(
                currency = Won(),
                value = 1000.0,
            ),
            target = Money(
                currency = Dollar(),
                value = 1450.0,
            ),
        )

        @Test
        fun `원화로 10달러를 환전하면 원화로는 14,500원의 결과를 도출한다`() {
            val calculateResult = ExchangeAmountCalculator.doCalculate(
                ExchangeCalculateRequest(
                    exchangeRate = mockExchangedRate,
                    targetAmount = Money(
                        currency = Dollar(),
                        value = 10.0,
                    )
                )
            )

            assertEquals(
                calculateResult.base.value,
                14500.0,
            )
        }

        @Test
        fun `원화로 10달러를 환전하면 달러는 10$의 결과를 도출한다`() {
            val calculateResult = ExchangeAmountCalculator.doCalculate(
                ExchangeCalculateRequest(
                    exchangeRate = mockExchangedRate,
                    targetAmount = Money(
                        currency = Dollar(),
                        value = 10.0,
                    )
                )
            )

            assertEquals(
                calculateResult.target.value,
                10.0,
            )
        }
    }
}