package com.capston_design.fkiller.itoms.service_request_management.domain.entity;
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

    @Column(name = "ticket_id", nullable = false)
    private UUID ticketId;

    @Column(name = "charger_id", nullable = false)
    private Long chargerId;

    @Column(name = "charger_name", nullable = false)
    private String chargerName;

    @Column(name = "charger_dept")
    private String chargerDept;

    @Column(name = "creator_id", nullable = false)
    private Long creatorId;

    @Column(name = "creator_name", nullable = false)
    private String creatorName;

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

    @Column(name = "ticket_plan_start_date", nullable = false)
    private LocalDateTime ticketPlanStartDate;

    @Column(name = "ticket_plan_end_date", nullable = false)
    private LocalDateTime ticketPlanEndDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TaskStatus status;

    @Column(name = "status_code", nullable = false)
    private String statusCode;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "active", nullable = false)
    private boolean active;
}
