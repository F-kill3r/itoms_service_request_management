package com.capston_design.fkiller.itoms.service_request_management.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "ticket_information")
public class TicketInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket_id", nullable = false)
    private Long ticketId;

    @Column(name = "ticket_plan_start_date", nullable = false)
    private LocalDateTime ticketPlanStartDate;

    @Column(name = "ticket_plan_end_date", nullable = false)
    private LocalDateTime ticketPlanEndDate;

}
