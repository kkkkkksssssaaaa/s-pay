package dev.kkkkkksssssaaaa.spay.exchange.domain.fee

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.impl.Won
import dev.kkkkkksssssaaaa.spay.exchange.domain.fee.strategy.FeeStrategyService
import dev.kkkkkksssssaaaa.spay.exchange.domain.fee.strategy.Strategy
import dev.kkkkkksssssaaaa.spay.exchange.domain.fee.strategy.StrategyType
import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money
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
@Import(CalculateBuyFeeService::class)
class CalculateBuyFeeServiceTest {
    @MockitoBean private lateinit var strategy: FeeStrategyService
    @Autowired private lateinit var calculator: CalculateBuyFeeService

    @Nested
    @DisplayName("수수료를 계산할 때")
    inner class DoCalculateTest {

        @Nested
        @DisplayName("수수료 정책 유형이 PERCENTAGE 이고")
        inner class PercentageTest {

            @Test
            fun `value 가 1 일 때 환전액의 1퍼센트를 수수료로 책정한다`() {
                // given
                `when`(strategy.getBuyStrategy())
                    .thenReturn(
                        Strategy(
                            type = StrategyType.PERCENTAGE,
                            value = 1.0
                        )
                    )

                // when
                val fee = calculator.doCalculate(
                    Money(
                        currency = Won(),
                        value = 1000.0
                    )
                )

                // then
                assertEquals(fee.amount.value, 10.0)
            }
        }

        @Nested
        @DisplayName("수수료 정책 유형이 STATIC 이고")
        inner class StaticTest {

            @Test
            fun `금액이 199,999원 이하라면 2000원을 수수료로 책정한다`() {
                // given
                `when`(strategy.getBuyStrategy())
                    .thenReturn(
                        Strategy(
                            type = StrategyType.STATIC,
                            value = 0.0
                        )
                    )

                // when
                val fee = calculator.doCalculate(
                    Money(
                        currency = Won(),
                        value = 199999.9
                    )
                )

                assertEquals(fee.amount.value, 2000.0)
            }

            @Test
            fun `금액이 20만원이라면 4000원을 수수료로 책정한다`() {
                // given
                `when`(strategy.getBuyStrategy())
                    .thenReturn(
                        Strategy(
                            type = StrategyType.STATIC,
                            value = 0.0
                        )
                    )

                // when
                val fee = calculator.doCalculate(
                    Money(
                        currency = Won(),
                        value = 200000.0
                    )
                )

                assertEquals(fee.amount.value, 4000.0)
            }
        }
    }
}