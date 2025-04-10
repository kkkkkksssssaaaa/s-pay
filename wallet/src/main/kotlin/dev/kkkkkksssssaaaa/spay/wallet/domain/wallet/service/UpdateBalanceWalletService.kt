package dev.kkkkkksssssaaaa.spay.wallet.domain.wallet.service

import dev.kkkkkksssssaaaa.spay.wallet.domain.wallet.Wallet
import dev.kkkkkksssssaaaa.spay.wallet.domain.wallet.repository.WalletRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateBalanceWalletService(
    private val repository: WalletRepository
) {
    @Transactional
    fun doUpdate(wallet: Wallet) {
        val entity = repository.findById(wallet.id)
            .orElseThrow { IllegalStateException("Wallet not found") }

        entity.doUpdateBalance(
            balance = wallet.balance.value,
        )

        repository.save(entity)
    }
}