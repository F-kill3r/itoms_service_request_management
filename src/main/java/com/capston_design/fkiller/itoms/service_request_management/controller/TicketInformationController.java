package com.capston_design.fkiller.itoms.service_request_management.controller;

import com.capston_design.fkiller.itoms.service_request_management.common.service.ClockHolder;
import com.capston_design.fkiller.itoms.service_request_management.controller.dto.request.AssignedTicketListRequestDTO;
import com.capston_design.fkiller.itoms.service_request_management.controller.dto.request.completeTicketRequestDTO;
import com.capston_design.fkiller.itoms.service_request_management.controller.dto.response.AssignedTicketListResponseDTO;
import com.capston_design.fkiller.itoms.service_request_management.controller.dto.response.TicketInformationResponseDTO;
import com.capston_design.fkiller.itoms.service_request_management.service.TicketInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-request-management/ticket-info")
@RequiredArgsConstructor
public class TicketInformationController {

    private final TicketInformationService ticketInformationService;
    private final ClockHolder clockHolder;

    @PostMapping("/v1/tickets")
    public AssignedTicketListResponseDTO getTicketList(@RequestBody AssignedTicketListRequestDTO request) {
        List<TicketInformationResponseDTO> ticketInformationServiceTicketList =
                ticketInformationService.getTicketList(request.getChargerId());
        return new AssignedTicketListResponseDTO(ticketInformationServiceTicketList);
    }

    @PostMapping("/v1/ticket/complete")
    public ResponseEntity<Void> completeTicket(@RequestBody completeTicketRequestDTO request) {
        ticketInformationService.completeTicket(request, clockHolder.now());
        return ResponseEntity.ok().build();
    }

}
