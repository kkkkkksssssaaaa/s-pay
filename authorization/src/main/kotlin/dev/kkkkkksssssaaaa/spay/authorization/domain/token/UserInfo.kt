package dev.kkkkkksssssaaaa.spay.authorization.domain.token

data class UserInfo(
    val id: String,
    val username: String,
    val roles: List<String>
)