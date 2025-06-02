package com.capston_design.fkiller.itoms.service_request_management.controller.dto.response;

import com.capston_design.fkiller.itoms.service_request_management.domain.entity.task.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class TaskResponseInformation {
    private UUID ticketId;
    private UUID incidentId;
    private UUID taskId;
    private String taskName;
    private TaskStatus taskStatus;
}
