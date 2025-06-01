package com.capston_design.fkiller.itoms.service_request_management.controller;

import com.capston_design.fkiller.itoms.service_request_management.controller.dto.request.AssignedTicketListRequestDTO;
import com.capston_design.fkiller.itoms.service_request_management.controller.dto.response.AssignedTicketListResponseDTO;
import com.capston_design.fkiller.itoms.service_request_management.controller.dto.response.TicketInformationResponseDTO;
import com.capston_design.fkiller.itoms.service_request_management.service.TicketInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/service-request-management/ticket-info")
@RequiredArgsConstructor
public class TicketInformationController {

    private final TicketInformationService ticketInformationService;

    @PostMapping("/v1/tickets")
    public AssignedTicketListResponseDTO getTicketList(@RequestBody AssignedTicketListRequestDTO request) {
        List<TicketInformationResponseDTO> ticketInformationServiceTicketList =
                ticketInformationService.getTicketList(request.getChargerId());
        return new AssignedTicketListResponseDTO(ticketInformationServiceTicketList);
    }

}
