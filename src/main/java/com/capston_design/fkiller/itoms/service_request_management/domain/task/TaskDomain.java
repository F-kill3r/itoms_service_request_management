package com.capston_design.fkiller.itoms.service_request_management.domain.task;

import com.capston_design.fkiller.itoms.service_request_management.domain.entity.task.TaskStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskDomain {
    private UUID taskId;
    private UUID ticketId;
    private UUID incidentId;
    private boolean isDeleted;
    private TaskStatus taskStatus;
    private String statusCode;
    private String taskName;
    private String taskContent;
    private boolean taskActive;
    private  String ticketName;
    private LocalDateTime ticketPlanStartDate;
    private LocalDateTime ticketPlanEndDate;
    private String chargerId;
    private String chargerName;

    private TaskDomain(UUID ticketId, UUID incidentId, String taskName,
                      String ticketName, String chargerId, String chargerName) {

        this.ticketId = ticketId;
        this.incidentId = incidentId;
        this.isDeleted = false;
        this.taskStatus = TaskStatus.NOT_STARTED;
        this.statusCode = TaskStatus.NOT_STARTED.getCode();
        this.taskName = taskName;
        this.taskActive = false;
        this.ticketName = ticketName;
        this.chargerId = chargerId;
        this.chargerName = chargerName;
    }

    public static TaskDomain createInitTaskDomain(UUID ticketId, String ticketName, UUID incidentId,
                                                String chargerId, String chargerName, String taskName) {
        return new TaskDomain(ticketId, incidentId,
                taskName, ticketName, chargerId, chargerName);
    }

    public static TaskDomain createTaskDomain(UUID taskId, UUID ticketId, UUID incidentId, boolean isDeleted,
                                              TaskStatus taskStatus, String statusCode, String taskName,
                                              String taskContent, boolean taskActive, String ticketName,
                                              LocalDateTime ticketPlanStartDate, LocalDateTime ticketPlanEndDate,
                                              String chargerId, String chargerName) {
        return new TaskDomain(taskId, ticketId, incidentId, isDeleted, taskStatus, statusCode,
                taskName, taskContent, taskActive, ticketName, ticketPlanStartDate,
                ticketPlanEndDate, chargerId, chargerName);
    }
}
