package com.capston_design.fkiller.itoms.service_request_management.domain.ticket;

import com.capston_design.fkiller.itoms.service_request_management.domain.entity.ticket_information.TicketStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class TicketCreator {

    public TicketDomain createInitTicket(UUID ticketId, UUID incidentId, String ticketName, String ticketContent,
                                         TicketStatus ticketStatus, String creatorId, String creatorName,
                                         String chargerId, String chargerName){

        return TicketDomain.createTicketWithoutPlanDate(ticketId, incidentId, ticketName, ticketContent,
                ticketStatus, creatorId, creatorName, chargerId, chargerName);
    }

    public TicketDomain createTicket(UUID ticketId, UUID incidentId, String ticketName, String ticketContent,
                                     TicketStatus ticketStatus, LocalDateTime planStartDate, String planDuration,
                                     String creatorId, String creatorName, String chargerId, String chargerName){

        return TicketDomain.createTicket(ticketId, incidentId, ticketName, ticketContent, ticketStatus,
                planStartDate, planDuration, creatorId, creatorName, chargerId, chargerName);
    }
}
