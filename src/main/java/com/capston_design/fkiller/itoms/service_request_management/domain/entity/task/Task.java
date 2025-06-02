package com.capston_design.fkiller.itoms.service_request_management.domain.entity.task;
import com.capston_design.fkiller.itoms.service_request_management.domain.entity.ticket_information.TicketInformation;
import com.capston_design.fkiller.itoms.service_request_management.domain.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "TASK")
public class Task extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "incident_id", nullable = false)
    private UUID incidentId;

    @Column(name = "ticket_id")
    private UUID ticketId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id", insertable = false, updatable = false)
    private TicketInformation ticketInformation;

    @Column(name = "charger_dept")
    private String chargerDept;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @Enumerated(EnumType.STRING)
    @Column(name = "approval_status")
    private ApprovalStatus approvalStatus;

    @Column(name = "progress_rate")
    private Integer progressRate;

    @Column(name = "closed_at")
    private LocalDateTime closedAt;

    @Column(name = "accepted_at")
    private LocalDateTime acceptedAt;

    @Column(name = "plan_start_date")
    private LocalDateTime planStartDate;

    @Column(name = "plan_end_date")
    private LocalDateTime planEndDate;

    @Column(name = "plan_duration")
    private LocalDateTime planDuration;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_status", nullable = false)
    private TaskStatus taskStatus;

    @Column(name = "status_code", nullable = false)
    private String statusCode;

    @Column(name = "task_name", nullable = false)
    private String taskName;

    @Column(name = "task_content", columnDefinition = "TEXT")
    private String taskContent;

    @Column(name = "task_active", nullable = false)
    private boolean taskActive;

    public void updateTaskStatus(TaskStatus taskStatus){
        this.taskStatus = taskStatus;
        this.statusCode = taskStatus.getCode();
        this.taskActive = checkTaskActive();
    }

    private boolean checkTaskActive() {
        return this.taskStatus == TaskStatus.IN_PROGRESS;
    }

}
