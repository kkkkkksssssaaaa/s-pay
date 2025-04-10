package dev.kkkkkksssssaaaa.spay.authorization.domain.token

data class Token(
    val value: String,
    val expiresIn: Long,
    val userInfo: UserInfo
)