package dev.kkkkkksssssaaaa.spay.authorization.domain.token

import com.fasterxml.jackson.annotation.JsonIgnore

data class Token(
    val value: String,
    @JsonIgnore val expiresIn: Long,
    @JsonIgnore val userInfo: UserInfo
)