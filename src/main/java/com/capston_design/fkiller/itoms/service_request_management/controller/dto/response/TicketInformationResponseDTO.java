package com.capston_design.fkiller.itoms.service_request_management.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class TicketInformationResponseDTO {
    private UUID incidentId;
    private UUID ticketId;
    @Nullable
    private String ticketName;
}
