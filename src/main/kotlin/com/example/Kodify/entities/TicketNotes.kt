package com.example.Kodify.entities


import com.example.Kodify.AuditTrail
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "ticket_notes")

data class TicketNotes(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(columnDefinition = "TEXT") // we use this for potentially long texts, the notes can be lengthy
    val noteText: String,

    //...Relationship...

    // FK - ticket_id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    val ticket: Ticket

) : AuditTrail()