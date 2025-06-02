package com.capston_design.fkiller.itoms.service_request_management.controller;

import com.capston_design.fkiller.itoms.service_request_management.controller.dto.request.CreateTasksRequestDTO;
import com.capston_design.fkiller.itoms.service_request_management.controller.dto.response.CreateTasksResponseDTO;
import com.capston_design.fkiller.itoms.service_request_management.controller.dto.response.TaskResponseInformation;
import com.capston_design.fkiller.itoms.service_request_management.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/service-request-management")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/v1/task")
    public CreateTasksResponseDTO createTask(@RequestBody CreateTasksRequestDTO request){
        TaskResponseInformation taskResponseInformation = taskService.createTask(request);
        return new CreateTasksResponseDTO(taskResponseInformation);
    }

}
