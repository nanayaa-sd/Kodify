package com.example.Kodify.entities

import jakarta.persistence.*

@Entity
@Table(name = "category")
data class Category(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(unique = true)
    val name: String
)
