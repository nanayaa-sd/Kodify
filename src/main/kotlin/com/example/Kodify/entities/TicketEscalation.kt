package com.example.Kodify.entities


import jakarta.persistence.*
import java.time. Instant



@Entity
@Table(name = "ticket_escalations")
data class TicketEscalation(



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,


    val reason: String,



    val created_at: Instant = Instant.now()


    //.....Relationships.....

    // FK - ticket_id
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    val ticket: Ticket,

    // FK - escalated_by (User who escalated it)
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "escalated_by")
    val escalatedBy: User

    // FK - escalated_to
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "escalated_to")
    val escalatedTo: User
)