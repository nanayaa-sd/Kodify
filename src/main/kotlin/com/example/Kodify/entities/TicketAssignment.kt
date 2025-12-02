package com.example.Kodify.entities


import jakarta.persistence.*
import java.time.Instant


@Entity
@Table(name= "ticket_assignments")
data class TicketAssignment(


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,


    val assignedAt: Instant = Instant.now(),
    val modifiedAt: Instant? = null,
    val reassignedAt: Instant? = null,
    // supervisor/admin

    //------Relationships-------

    // FK - ticket_id
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColum(name = "ticket_id")
    val ticket: Ticket,


    // FK - user_id (the agent assigned)
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_agent_id")
    val agent: User,

    // FK - previous_agent_id
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "previous_agent_id")
    val previousAgent: User? null,

    // FK - modified_by
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "modified_by")
    val modifiedBy: User? = null,

    // FK - assigned_by (supervisor / admin)
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_by")
    val assignedBy: User
)