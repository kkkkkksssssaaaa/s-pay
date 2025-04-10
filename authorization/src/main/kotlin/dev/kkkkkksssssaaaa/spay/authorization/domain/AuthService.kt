package dev.kkkkkksssssaaaa.spay.authorization.domain

import dev.kkkkkksssssaaaa.spay.authorization.domain.token.TokenProvider
import dev.kkkkkksssssaaaa.spay.authorization.domain.token.TokenResponse
import dev.kkkkkksssssaaaa.spay.authorization.domain.token.repository.RefreshTokenEntity
import dev.kkkkkksssssaaaa.spay.authorization.domain.token.repository.TokenRepository
import dev.kkkkkksssssaaaa.spay.authorization.domain.user.UserAdapter
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userAdapter: UserAdapter,
    private val tokenProvider: TokenProvider,
    private val tokenRepository: TokenRepository
) {
    fun login(
        username: String,
        password: String
    ): TokenResponse {
        val user = userAdapter.verifyUser(username, password)

        val accessToken = tokenProvider.createAccessToken(user)
        val refreshToken = tokenProvider.createRefreshToken(user)

        tokenRepository.save(
            RefreshTokenEntity(user.userId, refreshToken.value)
        )

        return TokenResponse(
            accessToken = accessToken,
            refreshToken = refreshToken
        )
    }
}