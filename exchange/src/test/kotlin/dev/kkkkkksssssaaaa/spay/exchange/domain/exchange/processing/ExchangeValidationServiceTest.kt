package dev.kkkkkksssssaaaa.spay.exchange.domain.exchange.processing

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.impl.Won
import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money
import dev.kkkkkksssssaaaa.spay.exchange.domain.wallet.Wallet
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExchangeValidationServiceTest {
    private val service = ExchangeValidationService()

    @Nested
    @DisplayName("DoValidateTest")
    inner class DoValidateTest {
        @Test
        fun `지갑에 있는 잔액이 환전할 금액보다 큰 경우 예외를 던지지 않는다`() {
            // given
            val wallet = Wallet(
                id = 1L,
                balance = Money(
                    currency = Won(),
                    value = 10000.0
                )
            )

            val calculatedAmount = Money(
                currency = Won(),
                value = 9999.9
            )

            // then
            assertDoesNotThrow {
                service.doValidate(wallet, calculatedAmount)
            }
        }

        @Test
        fun `지갑에 있는 잔액이 환전할 금액보다 적은 경우 IllegalArgumentException 을 던진다`() {
            // given
            val wallet = Wallet(
                id = 1L,
                balance = Money(
                    currency = Won(),
                    value = 9999.9
                )
            )

            val calculatedAmount = Money(
                currency = Won(),
                value = 10000.0
            )

            // then
            assertThrows<IllegalArgumentException> {
                service.doValidate(wallet, calculatedAmount)
            }
        }

        @Test
        fun `지갑에 있는 잔액이 환전할 금액과 동일한 경우 예외를 던지지 않는다`() {
            // given
            val wallet = Wallet(
                id = 1L,
                balance = Money(
                    currency = Won(),
                    value = 10000.0
                )
            )

            val calculatedAmount = Money(
                currency = Won(),
                value = 10000.0
            )

            // then
            assertDoesNotThrow {
                service.doValidate(wallet, calculatedAmount)
            }
        }

        @Test
        fun `환전할 금액과 상관 없이 지갑에 잔액이 없는 경우 IllegalArgumentException 을 던진다`() {
            // given
            val wallet = Wallet(
                id = 1L,
                balance = Money(
                    currency = Won(),
                    value = 0.0
                )
            )

            val calculatedAmount = Money(
                currency = Won(),
                value = 10000.0
            )

            // then
            assertThrows<IllegalArgumentException> {
                service.doValidate(wallet, calculatedAmount)
            }
        }

        @Test
        fun `지갑의 잔액과 상관 없이 환전할 금액이 0인 경우 IllegalArgumentException 을 던진다`() {
            // given
            val wallet = Wallet(
                id = 1L,
                balance = Money(
                    currency = Won(),
                    value = 10000.0
                )
            )

            val calculatedAmount = Money(
                currency = Won(),
                value = 0.0
            )

            // then
            assertThrows<IllegalArgumentException> {
                service.doValidate(wallet, calculatedAmount)
            }
        }
    }
}