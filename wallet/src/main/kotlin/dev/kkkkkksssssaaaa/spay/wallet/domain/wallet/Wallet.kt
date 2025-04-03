package dev.kkkkkksssssaaaa.spay.wallet.domain.wallet

import dev.kkkkkksssssaaaa.spay.wallet.domain.currency.Currency
import dev.kkkkkksssssaaaa.spay.wallet.domain.money.Money
import dev.kkkkkksssssaaaa.spay.wallet.domain.user.User
import dev.kkkkkksssssaaaa.spay.wallet.domain.wallet.repository.WalletJpaEntity

class Wallet(
    val id: Long,
    val user: User,
    val balance: Money,
) {
    companion object {
        fun of(
            entity: WalletJpaEntity,
            user: User,
        ): Wallet {
            return Wallet(
                id = entity.id!!,
                user = user,
                balance = Money(
                    value = entity.balance,
                    currency = Currency.typeOf(entity.currency),
                ),
            )
        }
    }
}