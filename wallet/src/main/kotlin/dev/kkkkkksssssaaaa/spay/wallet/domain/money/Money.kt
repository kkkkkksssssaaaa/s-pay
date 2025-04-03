package dev.kkkkkksssssaaaa.spay.wallet.domain.money

import dev.kkkkkksssssaaaa.spay.wallet.domain.currency.Currency

/**
 * 돈을 표현하는 객체
 *
 * operator function 호출시 인자가 Money 인 경우 통화가 다르면 계산 불가
 * operator function 호출시 인자가 Double 인 경우 기준 통화로 계산
 * */
class Money(
    val currency: Currency,
    val value: Double
) {
    operator fun compareTo(target: Money): Int {
        return this.value.compareTo(target.value)
    }

    operator fun times(target: Money): Money {
        checkCurrency(target)

        val result = this.value * target.value

        checkZero(result)

        return Money(
            this.currency,
            this.value * target.value
        )
    }

    operator fun times(target: Double): Money {
        val result = this.value * target

        checkZero(result)

        return Money(
            this.currency,
            this.value * target
        )
    }

    operator fun plus(target: Money): Money {
        checkCurrency(target)

        val result = this.value + target.value

        checkZero(result)

        return Money(
            this.currency,
            this.value + target.value
        )
    }

    operator fun plus(target: Double): Money {
        val result = this.value + target

        checkZero(result)

        return Money(
            this.currency,
            this.value + target
        )
    }

    operator fun minus(target: Money): Money {
        checkCurrency(target)

        val result = this.value - target.value

        checkZero(result)

        return Money(
            this.currency,
            this.value - target.value
        )
    }

    operator fun minus(target: Double): Money {
        val result = this.value - target

        checkZero(result)

        return Money(
            this.currency,
            this.value - target
        )
    }

    private fun checkCurrency(money: Money) {
        if (currency != money.currency) {
            throw IllegalArgumentException("지갑과 통화가 다릅니다.")
        }
    }

    private fun checkZero(money: Double) {
        if (money <= 0) {
            throw IllegalArgumentException("Result must be greater than 0.")
        }
    }
}