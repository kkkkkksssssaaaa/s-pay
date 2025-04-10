package dev.kkkkkksssssaaaa.spay.authorization.domain.token.repository

import org.springframework.data.jpa.repository.JpaRepository

interface TokenRepository: JpaRepository<RefreshTokenEntity, Long> {
}