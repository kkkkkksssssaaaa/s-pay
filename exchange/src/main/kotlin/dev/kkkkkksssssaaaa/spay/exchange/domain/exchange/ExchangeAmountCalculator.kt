package dev.kkkkkksssssaaaa.spay.exchange.domain.exchange

import dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate.ExchangedRate
import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money

/**
 * @property exchangeRate 환율
 * @property targetAmount 환전할 목표 금액
 * */
data class ExchangeCalculateRequest(
    val exchangeRate: ExchangedRate,
    var targetAmount: Money
)

/**
 * 환전 결과
 *
 * @property base 기준 통화, 환전할 외화 * 기준 통화의 현재 환율
 * @property target 환전할 외화 금액
 * */
data class ExchangeResult(
    val base: Money,
    val target: Money
)

/**
 * 환율 계산
 *
 * 현재 환율에 맞게 환전할 외화를 계산하고,
 * 현재 환율에 맞는 기준 통화를 계산
 * */
class ExchangeAmountCalculator {
    companion object {
        fun doCalculate(
            request: ExchangeCalculateRequest
        ): ExchangeResult {
            val target = doCalculateTarget(
                request.exchangeRate,
                request.targetAmount
            )

            val base = doCalculateBase(
                request.exchangeRate,
                request.targetAmount
            )

            return ExchangeResult(
                target = target,
                base = base
            )
        }
    }
}

private fun doCalculateTarget(
    exchangedRate: ExchangedRate,
    targetAmount: Money,
): Money {
    if (targetAmount <= 0.0) {
        throw IllegalArgumentException("Invalid request for this exchange")
    }

    return Money(
        currency = exchangedRate.target.currency,
        value = targetAmount.value
    )
}

private fun doCalculateBase(
    exchangedRate: ExchangedRate,
    targetAmount: Money,
): Money {
    val baseResult = exchangedRate.target.value * targetAmount.value

    if (baseResult <= 0.0) {
        throw IllegalArgumentException("Invalid request for this exchange")
    }

    return Money(
        currency = exchangedRate.base.currency,
        value = baseResult
    )
}
