package dev.kkkkkksssssaaaa.spay.exchange.domain.fee

import dev.kkkkkksssssaaaa.spay.exchange.domain.fee.strategy.FeeStrategyService
import dev.kkkkkksssssaaaa.spay.exchange.domain.fee.strategy.Strategy
import dev.kkkkkksssssaaaa.spay.exchange.domain.fee.strategy.StrategyType
import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money
import org.springframework.stereotype.Service

@Service
class CalculateBuyFeeService(
    private val strategy: FeeStrategyService
): CalculateFeeService() {
    override fun doCalculate(exchangeMoney: Money): Fee {
        val strategy = strategy.getBuyStrategy()

        return when (strategy.type) {
            StrategyType.PERCENTAGE -> {
                Fee(
                    strategy = strategy,
                    amount = calculatePercentageFee(strategy, exchangeMoney)
                )
            }
            StrategyType.STATIC -> {
                Fee(
                    strategy = strategy,
                    amount = calculatedStaticFee(strategy, exchangeMoney)
                )
            }
        }
    }

    override fun calculatePercentageFee(
        strategy: Strategy,
        exchangeMoney: Money
    ): Money {
        val feeAmount = exchangeMoney.value / 100.0 * strategy.value

        return Money(
            value = feeAmount,
            currency = exchangeMoney.currency
        )
    }

    override fun calculatedStaticFee(
        strategy: Strategy,
        exchangeMoney: Money
    ): Money {
        return when (exchangeMoney.value) {
            in 100000.0..199999.9 -> Money(
                value = 2000.0,
                currency = exchangeMoney.currency
            )
            in 200000.0..499999.9 -> Money(
                value = 4000.0,
                currency = exchangeMoney.currency
            )
            else -> Money(
                value = 0.0,
                currency = exchangeMoney.currency
            )
        }
    }
}