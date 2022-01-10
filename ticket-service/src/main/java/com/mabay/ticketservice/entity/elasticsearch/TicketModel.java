package com.mabay.ticketservice.entity.elasticsearch;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "ticket")
public class TicketModel implements Serializable {

    /**
     * Note: @Id must be imported from Spring-Data not Jpa
     */
    @Id
    private String id;
    private String description;
    private String notes;
    private String assignee;
    private Date ticketDate;
    private String priorityType;
    private String ticketStatus;
}
