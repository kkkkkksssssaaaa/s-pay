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