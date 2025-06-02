package com.capston_design.fkiller.itoms.service_request_management.service;

import com.capston_design.fkiller.itoms.service_request_management.controller.dto.request.CreateTasksRequestDTO;
import com.capston_design.fkiller.itoms.service_request_management.controller.dto.response.TaskResponseInformation;


public interface TaskService {
    TaskResponseInformation createTask(CreateTasksRequestDTO request);
}
