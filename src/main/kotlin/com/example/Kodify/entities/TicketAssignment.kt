package com.example.Kodify.entities


import com.example.Kodify.AuditTrail
import jakarta.persistence.*
import java.time.Instant
import java.util.*


@Entity
@Table(name = "ticket_assigments")

data class TicketAssignment(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,


    val reassignedAt: Instant? = null,

    //------Relationships-------

    // FK - ticket_id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    val ticket: Ticket,


    // FK - user_id (the agent assigned)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_agent_id")
    val agent: User,

    // FK - previous_agent_id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "previous_agent_id")
    val previousAgent: User? = null,

    // FK - modified_by
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modified_by")
    val modifiedBy: User? = null,

    // FK - assigned_by (supervisor / admin)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_by")
    val assignedBy: User
) : AuditTrail()