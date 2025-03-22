package dev.kkkkkksssssaaaa.spay.exchange.domain.wallet

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.impl.Won
import dev.kkkkkksssssaaaa.spay.exchange.domain.money.Money
import org.springframework.stereotype.Service

// TODO: wallet micro service call
interface WalletAdapter {
    fun get(id: Long): Wallet
}

@Service
internal class WalletAdapterImpl: WalletAdapter {
    override fun get(id: Long): Wallet {
        return Wallet(
            id = id,
            balance = Money(
                value = 100000.0,
                currency = Won(),
            ),
        )
    }
}