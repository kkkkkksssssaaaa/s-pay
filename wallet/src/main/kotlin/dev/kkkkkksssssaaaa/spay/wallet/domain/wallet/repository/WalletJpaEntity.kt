package dev.kkkkkksssssaaaa.spay.wallet.domain.wallet.repository

import dev.kkkkkksssssaaaa.spay.wallet.common.entity.CommonJpaEntity
import dev.kkkkkksssssaaaa.spay.wallet.domain.currency.CurrencyType
import jakarta.persistence.*

@Entity
@Table(
    name = "wallet",
    indexes = [
        Index(
            name = "idx_user_id",
            columnList = "user_id",
        ),
    ],
)
class WalletJpaEntity(
    userId: Long,
    currency: CurrencyType,
): CommonJpaEntity() {
    @Column(
        nullable = false,
        name = "balance"
    )
    var balance: Double = 0.0
        protected set

    @Column(
        nullable = false,
        updatable = false,
        name = "currency"
    )
    @Enumerated(EnumType.STRING)
    var currency: CurrencyType = currency
        protected set

    @Column(
        nullable = false,
        updatable = false,
        name = "user_id"
    )
    var userId: Long = 0L
        protected set
}