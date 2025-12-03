package com.example.Kodify.entities

import com.example.Kodify.AuditTrail
import com.example.Kodify.enums.UserRole
import jakarta.persistence.*

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

) : AuditTrail()
