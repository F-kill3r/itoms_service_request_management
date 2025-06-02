package com.capston_design.fkiller.itoms.service_request_management.repository;

import com.capston_design.fkiller.itoms.service_request_management.domain.entity.ticket_information.TicketInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TicketInformationRepository extends JpaRepository<TicketInformation, Long> {
    Optional<TicketInformation> findByTicketId(UUID ticketId);
}
