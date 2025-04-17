package dev.kkkkkksssssaaaa.spay.authorization.common.entity

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class CommonJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set

    @Column(
        nullable = false,
        updatable = false,
        name = "created_at"
    )
    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()
        protected set

    @Column(
        nullable = false,
        updatable = false,
        name = "created_by"
    )
    var createdBy: String = "system"
        protected set

    @Column(
        nullable = true,
        updatable = false,
        name = "updated_at"
    )
    @LastModifiedDate
    var updatedAt: LocalDateTime? = null
        protected set

    @Column(
        nullable = true,
        updatable = false,
        name = "updated_by"
    )
    var updatedBy: String? = "system"
        protected set

    @Column(
        nullable = false,
        name = "used"
    )
    var used: Boolean = true
        protected set
}