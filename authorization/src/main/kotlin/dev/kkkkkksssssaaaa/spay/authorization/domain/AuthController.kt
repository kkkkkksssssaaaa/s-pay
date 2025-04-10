package dev.kkkkkksssssaaaa.spay.authorization.domain

import dev.kkkkkksssssaaaa.spay.authorization.domain.token.TokenResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/auth")
class AuthController(
    private val authService: AuthService
) {

    @PostMapping("/login")
    fun login(
        @RequestBody request: LoginRequest
    ): ResponseEntity<TokenResponse> {
        val tokens = authService.login(request.username, request.password)

        return ResponseEntity.ok(tokens)
    }
}