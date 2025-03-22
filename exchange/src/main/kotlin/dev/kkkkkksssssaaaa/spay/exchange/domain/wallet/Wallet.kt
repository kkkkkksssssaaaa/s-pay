package dev.kkkkkksssssaaaa.spay.exchange.domain.wallet

import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money

data class Wallet(
    val id: Long,
    val balance: Money,
) {
}