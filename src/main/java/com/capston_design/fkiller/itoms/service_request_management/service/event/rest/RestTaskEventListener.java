package com.capston_design.fkiller.itoms.service_request_management.service.event.rest;

import com.capston_design.fkiller.itoms.service_request_management.client.TicketCoreClient;
import com.capston_design.fkiller.itoms.service_request_management.client.dto.request.UpdateTaskStatusRequestDTO;
import com.capston_design.fkiller.itoms.service_request_management.service.dto.TaskStatusUpdateEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestTaskEventListener {
    private final TicketCoreClient ticketCoreClient;

    @Async
    @EventListener
    public void handleTaskStatusUpdateEvent(TaskStatusUpdateEvent event) {
        ticketCoreClient.updateTaskStatus(event.getTaskId(),
                new UpdateTaskStatusRequestDTO(
                        event.getTicketId(),
                        event.getTaskName(),
                        event.getTaskStatus(),
                        event.getCompletionTime()
                ));
    }
}
