package com.capston_design.fkiller.itoms.service_request_management.repository;

import com.capston_design.fkiller.itoms.service_request_management.domain.entity.ticket_information.TicketInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketInformationRepository extends JpaRepository<TicketInformation, Long> {
}
