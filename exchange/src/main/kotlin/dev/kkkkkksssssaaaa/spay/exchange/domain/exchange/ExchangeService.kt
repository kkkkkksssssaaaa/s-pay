package dev.kkkkkksssssaaaa.spay.exchange.domain.exchange

import dev.kkkkkksssssaaaa.spay.exchange.domain.exchange.processing.ExchangeSettlementService
import dev.kkkkkksssssaaaa.spay.exchange.domain.exchange.processing.ExchangeValidationService
import dev.kkkkkksssssaaaa.spay.exchange.domain.exchangerate.ExchangeRateService
import org.springframework.stereotype.Service

/**
 * 환전 처리
 *
 * 1. 현재 환율 조회
 * 2. 환전할 금액 계산
 * 3. 환전 처리 가능 여부 검증
 * 4. 수수료 계산
 * 5. 기준 통화 지갑에 환전한 금액만큼 차감
 * 6. 외화 지갑에 환전할 금액만큼 증가
 * */
@Service
class ExchangeService(
    private val exchangeRate: ExchangeRateService,
    private val validator: ExchangeValidationService,
    private val settlement: ExchangeSettlementService,
) {
    fun doExchange(request: ExchangeRequest) {
        val exchangeRate = exchangeRate.getExchangeRate(
            baseCurrency = request.baseCurrency,
            targetCurrency = request.targetCurrency
        )

        val exchangedAmount = ExchangeAmountCalculator.doCalculate(
            ExchangeCalculateRequest(
                exchangeRate = exchangeRate,
                targetAmount = request.targetAmount
            )
        )

        validator.doValidate(
            wallet = request.wallet,
            calculatedAmount = exchangedAmount.base,
        )

        // 3. 수수료 계산
        val fee = settlement.doSettlement(request)
//        val finelAmount = exchangedAmount.minus(fee)


        // 4. 입/출금 처리
    }


}