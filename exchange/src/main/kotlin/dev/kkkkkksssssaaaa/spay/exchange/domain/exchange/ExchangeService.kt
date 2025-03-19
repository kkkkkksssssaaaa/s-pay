package dev.kkkkkksssssaaaa.spay.exchange.domain.exchange

import dev.kkkkkksssssaaaa.spay.exchange.domain.exchange.processing.ExchangeSettlementService
import dev.kkkkkksssssaaaa.spay.exchange.domain.exchange.processing.ExchangeValidationRequest
import dev.kkkkkksssssaaaa.spay.exchange.domain.exchange.processing.ExchangeValidationService
import dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate.ExchangeRateService
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
            exchangedRate = exchangeRate,
            exchangeRequest = request
        )

        val exchangedAmount = ExchangeAmountCalculator.doCalculate(
            ExchangeCalculateRequest(
                exchangeRate = exchangeRate,
                targetAmount = request.targetAmount
            )
        )

        validator.doValidate(
            calculatedAmount = exchangedAmount,
            request = exchangeRequest
        )

        // 3. 수수료 계산
        val fee = settlement.doSettlement(request)
//        val finelAmount = exchangedAmount.minus(fee)


        // 4. 입/출금 처리
    }


}