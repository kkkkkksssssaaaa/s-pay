package dev.kkkkkksssssaaaa.spay.authorization.domain.token

data class TokenResponse(
    val accessToken: Token,
    val refreshToken: Token,
)