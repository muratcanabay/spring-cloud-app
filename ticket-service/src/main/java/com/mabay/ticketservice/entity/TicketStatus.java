package com.mabay.ticketservice.entity;

import lombok.Getter;

@Getter
public enum TicketStatus {
    OPEN("Open"),
    IN_PROGRESS("In progress"),
    RESOLVED("Resolved"),
    CLOSED("Closed");

    private final String label;

    TicketStatus(String label) {
        this.label = label;
    }
}
