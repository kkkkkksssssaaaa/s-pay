package dev.kkkkkksssssaaaa.spay.exchange.domain.fee

import dev.kkkkkksssssaaaa.spay.exchange.domain.fee.strategy.Strategy
import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money
import org.springframework.stereotype.Service

@Service
class CalculateSellFeeService: CalculateFeeService() {
    override fun doCalculate(exchangeMoney: Money): Fee {
        TODO("Not yet implemented")
    }

    override fun calculatePercentageFee(strategy: Strategy, exchangeMoney: Money): Money {
        TODO("Not yet implemented")
    }

    override fun calculatedStaticFee(strategy: Strategy, exchangeMoney: Money): Money {
        TODO("Not yet implemented")
    }
}