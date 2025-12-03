package com.example.Kodify.entities


import com.example.Kodify.AuditTrail
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "ticket_escalation")

data class TicketEscalation(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    val reason: String,

    //.....Relationships.....

    // FK - ticket_id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    val ticket: Ticket,

    // FK - escalated_by (User who escalated it)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escalated_by")
    val escalatedBy: User,

    // FK - escalated_to
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escalated_to")
    val escalatedTo: User

) : AuditTrail()