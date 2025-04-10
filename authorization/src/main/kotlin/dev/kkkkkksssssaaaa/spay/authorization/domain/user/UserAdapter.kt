package dev.kkkkkksssssaaaa.spay.authorization.domain.user

import dev.kkkkkksssssaaaa.spay.authorization.domain.token.UserInfo
import org.springframework.cloud.openfeign.FeignClient

interface UserAdapter {
    fun verifyUser(
        username: String,
        password: String
    ): UserInfo
}

@FeignClient(
    name = "user-service",
    url = "http://user-service.local"
)
internal interface UserAdapterImpl: UserAdapter {
    override fun verifyUser(
        username: String,
        password: String
    ): UserInfo {
        // TODO: user microservice 구현 후 로그인 검증 요청
        return UserInfo(
            userId = "test",
            username = username,
            roles = listOf("ROLE_USER")
        )
    }
}