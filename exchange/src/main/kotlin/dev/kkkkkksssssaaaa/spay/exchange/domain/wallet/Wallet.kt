package dev.kkkkkksssssaaaa.spay.exchange.domain.wallet

import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money

/**
 * 지갑 도메인
 *
 * TODO: 입/출금시 지갑 서비스에 반영해야 함
 * */
data class Wallet(
    val id: Long,
    val balance: Money,
) {
    fun deposit(money: Money): Wallet {
        return copy(
            balance = balance + money
        )
    }

    fun withdrawal(money: Money): Wallet {
        return copy(
            balance = balance - money
        )
    }
}