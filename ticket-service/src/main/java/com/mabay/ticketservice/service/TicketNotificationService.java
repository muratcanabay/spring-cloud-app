package com.mabay.ticketservice.service;

import com.mabay.dto.TicketNotification;
import com.mabay.ticketservice.entity.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketNotificationService {

    private final StreamBridge streamBridge;

    public void sendTicket(Ticket ticket) {
        TicketNotification ticketNotification = TicketNotification.builder()
                .ticketId(ticket.getId())
                .ticketDescription(ticket.getDescription())
                .accountId(ticket.getAssignee())
                .build();
        streamBridge.send("ticketSender", ticketNotification);
    }
}
