package dev.kkkkkksssssaaaa.spay.authorization.domain.token.repository

import dev.kkkkkksssssaaaa.spay.authorization.common.entity.CommonJpaEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "refresh_token")
class RefreshTokenEntity(
    userId: String,
    token: String
): CommonJpaEntity() {
    @Column(
        nullable = false,
        updatable = false,
        name = "user_id"
    )
    val userId: String = userId

    @Column(
        nullable = false,
        updatable = false,
        name = "token"
    )
    val token: String = token

    fun doExpiration() {
        super.used = false
    }
}