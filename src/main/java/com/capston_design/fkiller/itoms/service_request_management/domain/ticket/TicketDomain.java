package com.capston_design.fkiller.itoms.service_request_management.domain.ticket;

import com.capston_design.fkiller.itoms.service_request_management.domain.entity.ticket_information.TicketStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketDomain {
    private UUID ticketId;
    private UUID incidentId;
    private String ticketName;
    private String ticketContent;
    private TicketStatus ticketStatus;
    private LocalDateTime planStartDate;
    private String planDuration;
    private String creatorId;
    private String creatorName;
    private String chargerId;
    private String chargerName;

    private TicketDomain(UUID ticketId, UUID incidentId, String ticketName,
                         String ticketContent, TicketStatus ticketStatus, String creatorId,
                         String creatorName, String chargerId, String chargerName) {
        this.ticketId = ticketId;
        this.incidentId = incidentId;
        this.ticketName = ticketName;
        this.ticketContent = ticketContent;
        this.ticketStatus = ticketStatus;
        this.creatorId = creatorId;
        this.creatorName = creatorName;
        this.chargerId = chargerId;
        this.chargerName = chargerName;
    }

    public static TicketDomain createTicketWithoutPlanDate(UUID ticketId, UUID incidentId, String ticketName,
                                                           String ticketContent, TicketStatus ticketStatus, String creatorId,
                                                           String creatorName, String chargerId, String chargerName) {
        return new TicketDomain(ticketId, incidentId, ticketName, ticketContent,
                ticketStatus, creatorId, creatorName, chargerId, chargerName);
    }

    public static TicketDomain createTicket(UUID ticketId, UUID incidentId, String ticketName, String ticketContent,
                                        TicketStatus ticketStatus, LocalDateTime planStartDate, String planDuration,
                                        String creatorId, String creatorName, String chargerId, String chargerName) {
        return new TicketDomain(ticketId, incidentId, ticketName, ticketContent, ticketStatus,
                planStartDate, planDuration, creatorId, creatorName, chargerId, chargerName);
    }
}
