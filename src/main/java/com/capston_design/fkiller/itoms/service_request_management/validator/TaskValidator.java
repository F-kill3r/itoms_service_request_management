package com.capston_design.fkiller.itoms.service_request_management.validator;

import com.capston_design.fkiller.itoms.service_request_management.repository.TicketInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskValidator {
    private final TicketInformationRepository ticketInformationRepository;


}
