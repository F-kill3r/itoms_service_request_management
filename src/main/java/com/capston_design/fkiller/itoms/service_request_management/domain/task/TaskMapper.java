package com.capston_design.fkiller.itoms.service_request_management.domain.task;

import com.capston_design.fkiller.itoms.service_request_management.controller.dto.response.TaskResponseInformation;
import com.capston_design.fkiller.itoms.service_request_management.domain.entity.task.Task;
import com.capston_design.fkiller.itoms.service_request_management.domain.entity.ticket_information.TicketInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskMapper {

    private final TaskCreator taskCreator;

    public Task toEntity(TaskDomain taskDomain){
        return Task.builder()
                .taskName(taskDomain.getTaskName())
                .incidentId(taskDomain.getIncidentId())
                .ticketId(taskDomain.getTicketId())
                .isDeleted(taskDomain.isDeleted())
                .taskStatus(taskDomain.getTaskStatus())
                .statusCode(taskDomain.getStatusCode())
                .taskContent(taskDomain.getTaskContent())
                .taskActive(taskDomain.isTaskActive())
                .build();
    }

    public TaskResponseInformation toTaskResponseInformation(UUID taskId, TaskDomain taskDomain) {
        return new TaskResponseInformation(
                taskDomain.getTicketId(),
                taskDomain.getIncidentId(),
                taskId,
                taskDomain.getTaskName(),
                taskDomain.getTaskStatus()
        );
    }
}
