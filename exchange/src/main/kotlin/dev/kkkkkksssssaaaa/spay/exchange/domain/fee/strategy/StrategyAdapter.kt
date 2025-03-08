package dev.kkkkkksssssaaaa.spay.exchange.domain.fee.strategy

import org.springframework.stereotype.Service

interface StrategyAdapter {
    fun getBuyStrategy(): Strategy
    fun getSellStrategy(): Strategy
}

@Service
internal class StrategyAdapterImpl : StrategyAdapter {
    override fun getBuyStrategy(): Strategy {
        return Strategy(
            type = StrategyType.PERCENTAGE,
            value = 1.2
        )
    }

    override fun getSellStrategy(): Strategy {
        return Strategy(
            type = StrategyType.PERCENTAGE,
            value = 1.2
        )
    }
}