package com.mabay.ticketservice.service.impl;

import com.mabay.AccountServiceClient;
import com.mabay.dto.AccountDto;
import com.mabay.ticketservice.dto.TicketDto;
import com.mabay.ticketservice.entity.PriorityType;
import com.mabay.ticketservice.entity.Ticket;
import com.mabay.ticketservice.entity.TicketStatus;
import com.mabay.ticketservice.entity.elasticsearch.TicketModel;
import com.mabay.ticketservice.repository.elasticsearch.TicketElasticRepository;
import com.mabay.ticketservice.repository.mysql.TicketRepository;
import com.mabay.ticketservice.service.TicketNotificationService;
import com.mabay.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketElasticRepository ticketElasticRepository;
    private final AccountServiceClient accountServiceClient;
    private final TicketNotificationService ticketNotificationService;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public TicketDto save(TicketDto ticketDto) {

        if (ticketDto.getDescription() == null)
            throw new IllegalArgumentException("Description field can not be empty");

        Ticket ticket = new Ticket();

        ResponseEntity<AccountDto> accountDtoResponseEntity = accountServiceClient.get(ticketDto.getAssignee());

        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setAssignee(Objects.requireNonNull(accountDtoResponseEntity.getBody()).getId());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));

        ticket = ticketRepository.save(ticket);

        TicketModel ticketModel = TicketModel.builder()
                .id(ticket.getId())
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .assignee(Objects.requireNonNull(accountDtoResponseEntity.getBody()).getUsernameSurname())
                .ticketDate(ticket.getTicketDate())
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .build();

        ticketElasticRepository.save(ticketModel);

        ticketDto.setId(ticket.getId());
        ticketNotificationService.sendTicket(ticket);
        return ticketDto;
    }

    @Override
    public TicketDto update(String id, TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getById(String id) {
        return modelMapper.map(ticketRepository.getById(id), TicketDto.class);
    }

    @Override
    public Page<TicketDto> getPagination(Pageable pageable) {
        TypeToken<Page<TicketDto>> typeToken = new TypeToken<>() {
        };
        Page<Ticket> tickets = ticketRepository.findAll(PageRequest.of(0, 20));
        return modelMapper.map(tickets, typeToken.getType());
    }
}
