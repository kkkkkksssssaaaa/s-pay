package dev.kkkkkksssssaaaa.spay.authorization.domain.user

import dev.kkkkkksssssaaaa.spay.authorization.domain.token.UserInfo
import org.springframework.stereotype.Component

interface UserAdapter {
    fun verifyUser(
        username: String,
        password: String
    ): UserInfo

    fun get(id: Long): UserInfo
}

@Component
internal class UserAdapterImpl: UserAdapter {
    override fun verifyUser(
        username: String,
        password: String
    ): UserInfo {
        // TODO: user microservice 구현 후 로그인 검증 요청
        return UserInfo(
            id = "test",
            username = username,
            roles = listOf("ROLE_USER")
        )
    }

    override fun get(id: Long): UserInfo {
        // TODO: user microservice 구현 후 내 정보 요청
        return UserInfo(
            id = "test",
            username = "testuser",
            roles = listOf("ROLE_USER")
        )
    }
}
