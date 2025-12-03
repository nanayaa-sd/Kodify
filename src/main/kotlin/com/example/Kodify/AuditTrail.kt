package com.example.Kodify

import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import java.time.Instant

@MappedSuperclass // this class is not an entity, its fields will be inherited by its child entities
abstract class AuditTrail {
    lateinit var created_at: Instant

    lateinit var updated_at: Instant

    @PrePersist
    fun setCreationTimestamp() {
        created_at = Instant.now()
        updated_at = Instant.now()
    }

    @PreUpdate
    fun setUpdateTimestamp() {
        updated_at = Instant.now()
    }
}