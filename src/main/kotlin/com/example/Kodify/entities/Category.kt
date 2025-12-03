package com.example.Kodify.entities

import com.example.Kodify.AuditTrail
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "category")
data class Category(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(unique = true)
    val name: String
) : AuditTrail()
