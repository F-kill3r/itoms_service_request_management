package com.capston_design.fkiller.itoms.service_request_management.service;

import com.capston_design.fkiller.itoms.service_request_management.controller.dto.response.TicketInformationResponseDTO;
import com.capston_design.fkiller.itoms.service_request_management.domain.ticket.TicketDomain;

import java.util.List;
import java.util.UUID;

public interface TicketInformationService {
    List<TicketInformationResponseDTO> getTicketList(String acceptorId);
    TicketDomain getTicketInformation(UUID ticketId);
}
