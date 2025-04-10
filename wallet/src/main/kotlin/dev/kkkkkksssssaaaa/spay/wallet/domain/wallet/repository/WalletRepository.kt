package dev.kkkkkksssssaaaa.spay.wallet.domain.wallet.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import dev.kkkkkksssssaaaa.spay.wallet.domain.user.User
import dev.kkkkkksssssaaaa.spay.wallet.domain.wallet.repository.QWalletJpaEntity.walletJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface WalletRepository: JpaRepository<WalletJpaEntity, Long>, WalletCustomRepository {
}

interface WalletCustomRepository {
    fun find(user: User): WalletJpaEntity?
}

@Repository
internal class WalletCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory,
): WalletCustomRepository {
    // TODO: 사용자가 지갑을 여러 개 가질 경우 예외 처리 필요
    override fun find(user: User): WalletJpaEntity? {
        return queryFactory.selectFrom(walletJpaEntity)
            .where(
                walletJpaEntity.userId.eq(user.id),
                walletJpaEntity.used.isTrue,
            )
            .fetchOne()
    }
}