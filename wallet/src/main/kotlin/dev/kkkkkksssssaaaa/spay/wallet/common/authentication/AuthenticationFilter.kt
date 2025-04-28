package dev.kkkkkksssssaaaa.spay.wallet.common.authentication

import dev.kkkkkksssssaaaa.spay.wallet.domain.user.adapter.AuthenticationUserAdapter
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class AuthenticationFilter(
    private val userAdapter: AuthenticationUserAdapter
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authorizationHeader = request.getHeader("Authorization")

        if (!authorizationHeader.isNullOrBlank()) {
            try {
                val userInfo = userAdapter.getCurrentUser(authorizationHeader)
                val authentication = CurrentAuthentication(userInfo)
                authentication.isAuthenticated = true

                SecurityContextHolder.getContext().authentication = authentication
            } catch (e: Exception) {
                logger.error("Authentication failed", e)
                throw e
            }
        }

        filterChain.doFilter(request, response)
    }
}
