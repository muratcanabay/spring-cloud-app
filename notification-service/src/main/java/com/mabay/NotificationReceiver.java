package com.mabay;

import com.mabay.dto.TicketNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@Slf4j
public class NotificationReceiver {

    @Bean
    public Consumer<TicketNotification> ticketReceiver() {
        return ticketNotification -> log.info("ticket received -> " + ticketNotification);
    }
}
