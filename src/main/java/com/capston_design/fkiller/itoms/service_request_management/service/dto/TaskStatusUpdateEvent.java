package com.capston_design.fkiller.itoms.service_request_management.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class TaskStatusUpdateEvent {
    private UUID taskId;
    private UUID ticketId;
    private String taskName;
    private String taskStatus;
    private String completionTime;
}
