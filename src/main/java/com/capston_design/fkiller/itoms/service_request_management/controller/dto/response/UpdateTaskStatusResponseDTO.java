package com.capston_design.fkiller.itoms.service_request_management.controller.dto.response;

import com.capston_design.fkiller.itoms.service_request_management.domain.entity.task.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class UpdateTaskStatusResponseDTO {
    private UUID taskId;
    private TaskStatus taskStatus;
}
