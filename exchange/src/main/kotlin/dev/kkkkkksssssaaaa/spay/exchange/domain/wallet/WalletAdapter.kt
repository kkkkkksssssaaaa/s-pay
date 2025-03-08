package dev.kkkkkksssssaaaa.spay.exchange.domain.wallet

import dev.kkkkkksssssaaaa.spay.exchange.domain.currency.CurrencyType
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
            amount = 10000,
            baseCurrency = CurrencyType.KRW
        )
    }
}