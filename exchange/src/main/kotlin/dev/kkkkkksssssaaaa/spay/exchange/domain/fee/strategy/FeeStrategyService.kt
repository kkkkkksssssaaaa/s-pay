package dev.kkkkkksssssaaaa.spay.exchange.domain.fee.strategy

import org.springframework.stereotype.Service

@Service
class FeeStrategyService(
    private val adapter: StrategyAdapter
) {
    fun getBuyStrategy(): Strategy {
        return adapter.getBuyStrategy()
    }

    fun getSellStrategy(): Strategy {
        return adapter.getSellStrategy()
    }
}