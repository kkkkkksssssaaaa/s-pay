package dev.kkkkkksssssaaaa.spay.wallet.domain.user.adapter

import dev.kkkkkksssssaaaa.spay.wallet.domain.user.User
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(
    name = "AuthenticationUserAdapter",
    url = "http://localhost:21003",
)
interface AuthenticationUserAdapter {
    @GetMapping("/v1/auth/users/me")
    fun getCurrentUser(
        @RequestHeader("Authorization") authHeader: String,
    ): User
}