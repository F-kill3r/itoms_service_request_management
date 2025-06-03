package com.capston_design.fkiller.itoms.service_request_management.service.event.rest;

import com.capston_design.fkiller.itoms.service_request_management.client.TicketCoreClient;
import com.capston_design.fkiller.itoms.service_request_management.client.dto.request.UpdateTicketStatusRequestDTO;
import com.capston_design.fkiller.itoms.service_request_management.service.dto.TicketStatusUpdateEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestTicketEventListener {
    private final TicketCoreClient ticketCoreClient;

    @Async
    @EventListener
    public void handleTicketStatusUpdateEvent(TicketStatusUpdateEvent event) {
        ticketCoreClient.updateTicketStatus(
                new UpdateTicketStatusRequestDTO(
                        event.getTicketId(),
                        event.getTicketName(),
                        event.getTicketStatus(),
                        event.getCompletionTime()
                ));
    }
}
