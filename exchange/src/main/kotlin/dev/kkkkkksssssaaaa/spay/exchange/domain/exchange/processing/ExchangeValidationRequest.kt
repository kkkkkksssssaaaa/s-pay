package dev.kkkkkksssssaaaa.spay.exchange.domain.exchange.processing

import dev.kkkkkksssssaaaa.spay.exchange.domain.exchange.ExchangeRequest
import dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate.ExchangeRate

data class ExchangeValidationRequest(
    val exchangeRequest: ExchangeRequest,
    val exchangeRate: ExchangeRate
)