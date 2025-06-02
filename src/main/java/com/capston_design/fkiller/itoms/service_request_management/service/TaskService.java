package com.capston_design.fkiller.itoms.service_request_management.service;

import com.capston_design.fkiller.itoms.service_request_management.controller.dto.request.CreateTasksRequestDTO;
import com.capston_design.fkiller.itoms.service_request_management.controller.dto.response.TaskResponseInformation;
import com.capston_design.fkiller.itoms.service_request_management.controller.dto.response.UpdateTaskStatusResponseDTO;

import java.util.UUID;


public interface TaskService {
    TaskResponseInformation createTask(CreateTasksRequestDTO request);
    UpdateTaskStatusResponseDTO updateTaskStatus(UUID taskId, String taskStatus, String updatedTime);

}
