package dev.kkkkkksssssaaaa.spay.exchange.domain.exchange

import dev.kkkkkksssssaaaa.spay.exchange.domain.exchange.processing.ExchangeSettlementService
import dev.kkkkkksssssaaaa.spay.exchange.domain.exchange.processing.ExchangeValidationRequest
import dev.kkkkkksssssaaaa.spay.exchange.domain.exchange.processing.ExchangeValidationService
import dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate.ExchangeRateService
import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money
import org.springframework.stereotype.Service

@Service
class ExchangeService(
    private val exchangeRate: ExchangeRateService,
    private val validator: ExchangeValidationService,
    private val settlement: ExchangeSettlementService,
) {
    fun doExchange(request: ExchangeRequest) {
        // 1. 현재 환율 조회
        val exchangeRate = exchangeRate.getExchangeRate(
            baseCurrency = request.baseCurrency,
            targetCurrency = request.targetCurrency
        )

        // 2. 환전할 금액만큼 지갑에 돈이 있는지 확인
        val exchangeRequest = ExchangeValidationRequest(
            exchangeRate = exchangeRate,
            exchangeRequest = request
        )

        val exchangedAmount = calculateExchangeAmount(
            ExchangeValidationRequest(
                exchangeRate = exchangeRate,
                exchangeRequest = request
            )
        )

        validator.doValidate(
            calculatedAmount = exchangedAmount,
            request = exchangeRequest
        )

        // 3. 수수료 계산
        val fee = settlement.doSettlement(exchangedAmount)
//        val finelAmount = exchangedAmount.minus(fee)


        // 4. 입/출금 처리
    }

    fun calculateExchangeAmount(
        request: ExchangeValidationRequest
    ): Money {
        val result = request.exchangeRate.target.amount *
            request.exchangeRequest.exchangedMoney.amount

        if (result <= 0) {
            throw IllegalArgumentException("Invalid request for this exchange")
        }

        return Money(
            currency = request.exchangeRequest.targetCurrency,
            amount = result
        )
    }
}