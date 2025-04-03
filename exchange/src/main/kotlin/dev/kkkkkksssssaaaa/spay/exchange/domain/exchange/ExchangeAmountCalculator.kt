package dev.kkkkkksssssaaaa.spay.exchange.domain.exchange

import dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate.ExchangedRate
import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money
import kotlin.math.round

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
 *
 * 계산 결과가 소수점이면 반올림 처리
 * */
class ExchangeAmountCalculator {
    companion object {
        fun doCalculate(
            request: ExchangeCalculateRequest
        ): ExchangeResult {
            val roundedResult = round(
                request.exchangeRate.target.value *
                    request.targetAmount.value
            )

            val base = Money(
                currency = request.exchangeRate.base.currency,
                value = roundedResult
            )

            return ExchangeResult(
                target = request.targetAmount,
                base = base
            )
        }
    }
}
