package dev.kkkkkksssssaaaa.spay.exchange.domain.fee.strategy

import org.springframework.stereotype.Service

// TODO: 통화에 따라 수수료 정책 각기 적용
interface StrategyAdapter {
    fun getBuyStrategy(): Strategy
    fun getSellStrategy(): Strategy
}

@Service
internal class StrategyAdapterImpl : StrategyAdapter {
    override fun getBuyStrategy(): Strategy {
        return Strategy(
            type = StrategyType.PERCENTAGE,
            value = 1.0
        )
    }

    override fun getSellStrategy(): Strategy {
        return Strategy(
            type = StrategyType.PERCENTAGE,
            value = 1.0
        )
    }
}