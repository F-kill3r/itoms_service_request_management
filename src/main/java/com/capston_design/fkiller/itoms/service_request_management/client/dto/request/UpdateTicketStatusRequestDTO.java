package com.capston_design.fkiller.itoms.service_request_management.client.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class UpdateTicketStatusRequestDTO {
    private UUID ticketId;
    private String ticketName;
    private String ticketStatus;
    private String completionTime;
}
