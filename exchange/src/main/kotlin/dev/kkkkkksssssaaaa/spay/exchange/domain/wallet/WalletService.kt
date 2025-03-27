package dev.kkkkkksssssaaaa.spay.exchange.domain.wallet

import org.springframework.stereotype.Service

@Service
class WalletService(
    private val adapter: WalletAdapter
) {
    fun get(id: Long): Wallet {
        return adapter.get(id)
    }
}