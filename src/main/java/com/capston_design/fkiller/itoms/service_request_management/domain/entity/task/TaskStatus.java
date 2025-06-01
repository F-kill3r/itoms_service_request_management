package com.capston_design.fkiller.itoms.service_request_management.domain.entity.task;

import lombok.Getter;

@Getter

public enum TaskStatus {
    NOT_STARTED("ts1000", "NOT_STARTED", "작업 시작 전"),
    IN_PROGRESS("ts1001", "IN_PROGRESS", "작업 진행 중"),
    COMPLETED("ts1002", "COMPLETED", "작업 완료됨");

    private final String code;
    private final String codeName;
    private final String description;

    TaskStatus(String code, String codeName, String description) {
        this.code = code;
        this.codeName = codeName;
        this.description = description;
    }

    public static TaskStatus fromCode(String code) {
        for (TaskStatus status : TaskStatus.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid TaskStatus code: " + code);
    }
}