package dev.kkkkkksssssaaaa.spay.exchange.domain.fee

import dev.kkkkkksssssaaaa.spay.exchange.domain.fee.strategy.Strategy
import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money

abstract class CalculateFeeService {
    abstract fun doCalculate(exchangeMoney: Money): Fee

    protected abstract fun calculatePercentageFee(
        strategy: Strategy,
        exchangeMoney: Money
    ): Money

    protected abstract fun calculatedStaticFee(
        strategy: Strategy,
        exchangeMoney: Money
    ): Money
}