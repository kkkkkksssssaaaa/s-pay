package dev.kkkkkksssssaaaa.spay.exchange.domain.currency

import dev.kkkkkksssssaaaa.spay.exchange.domain.wallet.Wallet

class ExchangeDollarService {
    fun doExchange(wallet: Wallet, amount: Double) {
        // 환율 조회
        // 지갑의 baseCurrency(사용자의 기본 통화)를 현재 USD 환율로 변경
        // 지갑의 잔액이 환전할 금액보다 많은지 체크
        // 외화 지갑에 환전할 금액을 추가
    }
}