package dev.kkkkkksssssaaaa.spay.authorization.domain.token

data class UserInfo(
    val userId: String,
    val username: String,
    val roles: List<String>
)