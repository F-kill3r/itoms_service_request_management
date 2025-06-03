package com.capston_design.fkiller.itoms.service_request_management.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class TicketStatusUpdateEvent {
    private UUID ticketId;
    private String ticketName;
    private String ticketStatus;
    private String completionTime;
}
