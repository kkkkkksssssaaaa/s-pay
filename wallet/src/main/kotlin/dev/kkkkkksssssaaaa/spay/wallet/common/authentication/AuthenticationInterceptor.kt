package dev.kkkkkksssssaaaa.spay.wallet.common.authentication

import dev.kkkkkksssssaaaa.spay.wallet.domain.user.adapter.AuthenticationUserAdapter
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
class AuthenticationInterceptor(
    private val userAdapter: AuthenticationUserAdapter
) : HandlerInterceptor {
    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any
    ): Boolean {
        val token = request.getHeader("Authorization")
            ?: throw RuntimeException("Authorization header not found")

        val userInfo = userAdapter.getCurrentUser(token)

        val authentication = CurrentAuthentication(userInfo)

        SecurityContextHolder.getContext().authentication = authentication

        return true
    }
}
