package com.capston_design.fkiller.itoms.service_request_management.domain.entity.ticket_information;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "ticket_information")
public class TicketInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket_id", nullable = false, unique = true)
    private UUID ticketId;

    @Column(name = "ticket_name", nullable = false)
    private String ticketName;

    @Column(name = "ticket_content")
    private String ticketContent;

    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_status", nullable = false)
    private TicketStatus ticketStatus;

    @Column(name = "incident_id", nullable = false)
    private UUID incidentId;

    @Column(name = "ticket_plan_start_date")
    private LocalDateTime ticketPlanStartDate;

    @Column(name = "ticket_plan_end_date")
    private LocalDateTime ticketPlanEndDate;

    @Column(name = "creator_id", nullable = false)
    private String creatorId;

    @Column(name = "creator_name", nullable = false)
    private String creatorName;

    @Column(name = "charger_id", nullable = false)
    private String chargerId;

    @Column(name = "charger_name", nullable = false)
    private String chargerName;

   @Builder
   public TicketInformation(UUID ticketId, String ticketName, String ticketContent, TicketStatus ticketStatus,
                        UUID incidentId, String creatorId, String creatorName, String chargerId, String chargerName) {
       this.ticketId = ticketId;
       this.ticketName = ticketName;
       this.ticketContent = ticketContent;
       this.ticketStatus = ticketStatus;
       this.incidentId = incidentId;
       this.creatorId = creatorId;
       this.creatorName = creatorName;
       this.chargerId = chargerId;
       this.chargerName = chargerName;
   }

   public void updateTicketStatus(TicketStatus ticketStatus) {
       this.ticketStatus = ticketStatus;
   }

}
