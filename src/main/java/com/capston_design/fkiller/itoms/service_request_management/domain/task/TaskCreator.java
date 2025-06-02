package com.capston_design.fkiller.itoms.service_request_management.domain.task;

import com.capston_design.fkiller.itoms.service_request_management.domain.ticket.TicketDomain;
import org.springframework.stereotype.Component;

@Component
public class TaskCreator {

    public TaskDomain createInitTaskDomain(String taskName, TicketDomain ticketDomain){
        return TaskDomain.createInitTaskDomain(
                ticketDomain.getTicketId(),
                ticketDomain.getTicketName(),
                ticketDomain.getIncidentId(),
                ticketDomain.getChargerId(),
                ticketDomain.getChargerName(),
                taskName
                );
    }
}
