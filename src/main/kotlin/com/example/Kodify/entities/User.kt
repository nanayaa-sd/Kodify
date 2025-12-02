package com.example.Kodify.entities

import jakarta.persistence.*
import java.time.Instant

enum class UserRole {
    CUSTOMER,
    SUPPORT_AGENT,
    TEAM_LEAD,
    ADMIN
}

@Entity
@Table(name = "app_users")
data class User(

    @Id
    @Column(name = "auth0_id", nullable = false)
    val id: String,
    // Auth0 is an external identity provider
    // Auth0 will generate and provide the unique identifier
    // the service layer will save the id from Auth0

    val name: String,

    @Column(unique = true, nullable = false)
    val email: String,

    @Enumerated(EnumType.STRING)
    val role: UserRole,

    val created_at: Instant = Instant.now(),

    val updated_at: Instant = Instant.now()
)
