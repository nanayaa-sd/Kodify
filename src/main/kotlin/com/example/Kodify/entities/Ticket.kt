package com.example.Kodify.entities
import com.example.Kodify.AuditTrail
import com.example.Kodify.enums.TicketPriority
import com.example.Kodify.enums.TicketStatus
import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "ticket")
data class Ticket(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(unique = true, nullable = false)
    val ticketNumber: String,

    val title: String,

    @Column(columnDefinition = "TEXT") // we use this for potentially long texts, descriptions can be lengthy
    val description: String,


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    val category: Category,

    @Enumerated(EnumType.STRING)
    val priority: TicketPriority,

    @Enumerated(EnumType.STRING)
    val status: TicketStatus = TicketStatus.NEW,

    // use @ElementCollection only for lists of basic data like strings or numbers
    @ElementCollection
    @CollectionTable(name = "ticket_attachment", joinColumns = [JoinColumn(name = "ticket_id")])
    @Column(name = "attachment_path")
    val attachments: MutableSet<String> = mutableSetOf(),

    ) : AuditTrail()
