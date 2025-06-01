package com.capston_design.fkiller.itoms.service_request_management.client.dto.response;

import com.capston_design.fkiller.itoms.service_request_management.domain.entity.ticket_information.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class TicketInformationDTO {
    private UUID ticketId;
    private UUID incidentId;
    private String ticketName;
    private String ticketContent;
    private TicketStatus ticketStatus;
    private LocalDateTime ticketPlanStartDate;
    private LocalDateTime ticketPlanDuration;
    private String creatorId;
    private String creatorName;
    private String acceptorId;
    private String acceptorName;
}
