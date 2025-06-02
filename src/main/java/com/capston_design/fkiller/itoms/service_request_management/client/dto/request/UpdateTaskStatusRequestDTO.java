package com.capston_design.fkiller.itoms.service_request_management.client.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class UpdateTaskStatusRequestDTO {
    private UUID ticketId;
    private String taskName;
    private String taskStatus;
    private String completionTime;
}
