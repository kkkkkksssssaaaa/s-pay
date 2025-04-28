package dev.kkkkkksssssaaaa.spay.authorization.domain

import dev.kkkkkksssssaaaa.spay.authorization.domain.token.TokenResponse
import dev.kkkkkksssssaaaa.spay.authorization.domain.token.UserInfo
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
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

    @GetMapping("/users/me")
    fun getMe(
        servletRequest: HttpServletRequest
    ): ResponseEntity<UserInfo> {
        val token = servletRequest.getHeader("Authorization").replace("Bearer ", "")

        return ResponseEntity.ok(
            authService.getAuthenticatedUser(token)
        )
    }
}