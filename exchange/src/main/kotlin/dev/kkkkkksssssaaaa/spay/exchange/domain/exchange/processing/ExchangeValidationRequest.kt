package dev.kkkkkksssssaaaa.spay.exchange.domain.exchange.processing

import dev.kkkkkksssssaaaa.spay.exchange.domain.exchange.ExchangeRequest
import dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate.ExchangedRate

data class ExchangeValidationRequest(
    val exchangeRequest: ExchangeRequest,
    val exchangedRate: ExchangedRate
)