package com.mabay.ticketservice.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "notes", length = 4000)
    private String notes;

    @Column(name = "assignee", length = 64)
    private String assignee;

    @Column(name = "ticket_date")
    private Date ticketDate;

    @Column(name = "priority_type")
    @Enumerated
    private PriorityType priorityType;

    @Column(name = "ticket_status")
    @Enumerated
    private TicketStatus ticketStatus;

}
