package com.mabay.ticketservice.service.impl;

import com.mabay.ticketservice.dto.TicketDto;
import com.mabay.ticketservice.entity.PriorityType;
import com.mabay.ticketservice.entity.Ticket;
import com.mabay.ticketservice.entity.TicketStatus;
import com.mabay.ticketservice.entity.elasticsearch.TicketModel;
import com.mabay.ticketservice.repository.mysql.TicketRepository;
import com.mabay.ticketservice.repository.elasticsearch.TicketElasticRepository;
import com.mabay.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketElasticRepository ticketElasticRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public TicketDto save(TicketDto ticketDto) {
        Ticket ticket = new Ticket();

        if (ticketDto.getDescription() == null)
            throw new IllegalArgumentException("Description field can not be empty");

        // TODO: Check assignee from account-service
        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));

        ticket = ticketRepository.save(ticket);

        TicketModel ticketModel = TicketModel.builder()
                .id(ticket.getId())
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .assignee(ticket.getAssignee())
                .ticketDate(ticket.getTicketDate())
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .build();

        ticketElasticRepository.save(ticketModel);

        ticketDto.setId(ticket.getId());
        return ticketDto;
    }

    @Override
    public TicketDto update(String id, TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getById(String id) {
        return null;
    }

    @Override
    public Page<TicketDto> getPagination(Pageable pageable) {
        return null;
    }
}
