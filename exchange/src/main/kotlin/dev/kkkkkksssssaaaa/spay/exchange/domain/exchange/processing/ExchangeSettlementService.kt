package dev.kkkkkksssssaaaa.spay.exchange.domain.exchange.processing

import dev.kkkkkksssssaaaa.spay.exchange.domain.exchange.ExchangeRequest
import dev.kkkkkksssssaaaa.spay.exchange.domain.fee.CalculateBuyFeeService
import dev.kkkkkksssssaaaa.spay.exchange.domain.fee.CalculateSellFeeService
import dev.kkkkkksssssaaaa.spay.exchange.domain.wallet.WalletService
import org.springframework.stereotype.Service

/**
 * 환전 후처리 클래스
 *
 * - 사용자의 외화 지갑에 환전한 금액만큼 입금
 * - 사용자의 원화 지갑에서 환전한 금액만큼 출금
 * - 수수료 부과
 * - 입/출금 알림 처리
 * */
@Service
class ExchangeSettlementService(
    private val buyFee: CalculateBuyFeeService,
    private val saleFee: CalculateSellFeeService,
    private val walletService: WalletService,
) {
    fun doSettlement(request: ExchangeRequest) {
        val fee = buyFee.doCalculate(request.exchangedMoney)
        val finalAmountValue = request.exchangedMoney.amount - fee.amount.amount


        // TODO: 출금 처리
        // TODO: 외화 지갑에 입금 처리
    }
}