package dev.kkkkkksssssaaaa.spay.exchange.domain.fee

import dev.kkkkkksssssaaaa.spay.exchange.domain.fee.strategy.Strategy

class Fee(
    val amount: Int,
    val strategy: Strategy
) {
}