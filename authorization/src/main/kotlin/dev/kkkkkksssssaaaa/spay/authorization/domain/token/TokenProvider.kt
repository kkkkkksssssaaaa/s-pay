package dev.kkkkkksssssaaaa.spay.authorization.domain.token

import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.Date

@Component
class TokenProvider {
    private val secret = "my_super_secure_32_byte_secret_key!" // 실제론 외부에서 주입
    private val key = Keys.hmacShaKeyFor(secret.toByteArray())

    fun createAccessToken(user: UserInfo): Token {
        val expiration15Min = Date(System.currentTimeMillis() + 1000 * 60 * 15)

        val value = Jwts.builder()
            .setSubject(user.id)
            .claim("roles", user.roles)
            .setIssuedAt(Date())
            .setExpiration(expiration15Min)
            .signWith(key)
            .compact()

        return Token(
            value = value,
            expiresIn = expiration15Min.time - System.currentTimeMillis(),
            userInfo = user
        )
    }

    fun createRefreshToken(user: UserInfo): Token {
        val expirationOneWeek = Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7)

        val value = Jwts.builder()
            .setSubject(user.id)
            .setIssuedAt(Date())
            .setExpiration(expirationOneWeek)
            .signWith(key)
            .compact()

        return Token(
            value = value,
            expiresIn = expirationOneWeek.time - System.currentTimeMillis(),
            userInfo = user
        )
    }

    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
            true
        } catch (e: ExpiredJwtException) {
            throw e
        } catch (e: Exception) {
            false
        }
    }

    fun getUserIdFromToken(token: String): String {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .body
            .subject
    }
}
