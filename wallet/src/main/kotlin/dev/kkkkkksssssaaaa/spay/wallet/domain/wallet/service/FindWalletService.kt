package dev.kkkkkksssssaaaa.spay.wallet.domain.wallet.service

import dev.kkkkkksssssaaaa.spay.wallet.domain.user.User
import dev.kkkkkksssssaaaa.spay.wallet.domain.wallet.Wallet
import dev.kkkkkksssssaaaa.spay.wallet.domain.wallet.repository.WalletRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FindWalletService(
    private val repository: WalletRepository,
) {
    @Transactional(readOnly = true)
    fun get(user: User): Wallet {
        return repository.find(user).let { entity ->
            entity?.let {
                Wallet.of(
                    entity = it,
                    user = user,
                )
            } ?: throw IllegalStateException("Wallet not found")
        }
    }
}