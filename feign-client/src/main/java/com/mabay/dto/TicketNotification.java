package com.mabay.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TicketNotification {

    private String ticketId;
    private String ticketDescription;
    private String accountId;
}
