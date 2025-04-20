package dev.kkkkkksssssaaaa.spay.wallet.common.authentication

import dev.kkkkkksssssaaaa.spay.wallet.domain.user.User
import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority

class CurrentAuthentication(
    private val userInfo: User
) : AbstractAuthenticationToken(userInfo.roles.map { SimpleGrantedAuthority(it) }) {
    override fun getCredentials(): Any = ""
    override fun getPrincipal(): Any = userInfo
    override fun isAuthenticated(): Boolean = true
}