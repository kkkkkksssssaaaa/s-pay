package dev.kkkkkksssssaaaa.spay.exchange.domain.exchange.processing

import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money
import dev.kkkkkksssssaaaa.spay.exchange.domain.wallet.WalletService
import org.springframework.stereotype.Service

/**
 * 환전을 위한 전처리 클래스
 *
 * - 환전할 금액이 0보다 크고 지갑에 있는 금액보다 작을 경우 환전할 수 있다.
 * - 환전할 금액이 지갑에 있는 금액보다 많을 경우 환전할 수 없다.
 * - 환전할 금액이 0보다 작을 경우 환전할 수 없다.
 * */
@Service
class ExchangeValidationService(
    private val walletService: WalletService
) {
    fun doValidate(
        calculatedAmount: Money,
        request: ExchangeValidationRequest
    ) {
        checkBalance(
            calculatedAmount,
            request
        )

        // TODO: add more validation strategies.....
    }

    fun checkBalance(
        calculatedMoney: Money,
        request: ExchangeValidationRequest
    ) {
        val wallet = walletService.get(request.exchangeRequest.walletId)

        if (wallet.amount < calculatedMoney.value) {
            throw IllegalArgumentException("Insufficient balance")
        }
    }
}