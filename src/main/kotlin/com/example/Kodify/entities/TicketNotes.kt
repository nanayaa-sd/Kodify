package com.example.Kodify.entities


import jakarta.persistence.*
import java.time. Instant


@Entity
@Table(name = "ticket_note")
data class TicketNotes(


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Lob // we use this for potentially long texts, descriptions can be lengthy
    val noteText: String,
    val created_at: Instant = Instant.now()

    //...Relationship...

    // FK - ticket_id
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    val ticket: Ticket
)