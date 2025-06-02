package com.capston_design.fkiller.itoms.service_request_management.controller.dto.request;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class CreateTasksRequestDTO {
    private UUID ticketId;
    private String taskName;
}
