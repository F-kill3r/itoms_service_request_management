package com.capston_design.fkiller.itoms.service_request_management.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketCompletedMessage {
    private UUID ticketId;
    private UUID incidentId;
} 