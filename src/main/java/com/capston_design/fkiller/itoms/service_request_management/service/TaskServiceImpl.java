package com.capston_design.fkiller.itoms.service_request_management.service;

import com.capston_design.fkiller.itoms.service_request_management.common.exception.BaseException;
import com.capston_design.fkiller.itoms.service_request_management.controller.dto.request.CreateTasksRequestDTO;
import com.capston_design.fkiller.itoms.service_request_management.controller.dto.response.TaskResponseInformation;
import com.capston_design.fkiller.itoms.service_request_management.controller.dto.response.UpdateTaskStatusResponseDTO;
import com.capston_design.fkiller.itoms.service_request_management.domain.entity.task.Task;
import com.capston_design.fkiller.itoms.service_request_management.domain.entity.task.TaskStatus;
import com.capston_design.fkiller.itoms.service_request_management.domain.task.TaskCreator;
import com.capston_design.fkiller.itoms.service_request_management.domain.task.TaskDomain;
import com.capston_design.fkiller.itoms.service_request_management.domain.task.TaskMapper;
import com.capston_design.fkiller.itoms.service_request_management.domain.ticket.TicketDomain;
import com.capston_design.fkiller.itoms.service_request_management.repository.TaskRepository;
import com.capston_design.fkiller.itoms.service_request_management.service.dto.TaskStatusUpdateEvent;
import com.capston_design.fkiller.itoms.service_request_management.service.event.rest.RestTaskEventListener;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService{

    private final TicketInformationService ticketInformationService;
    private final RestTaskEventListener restTaskEventListener;
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final TaskCreator taskCreator;

    @Transactional
    @Override
    public TaskResponseInformation createTask(CreateTasksRequestDTO request) {
        TicketDomain ticketDomain = ticketInformationService.getTicketInformation(request.getTicketId());
        TaskDomain taskDomain = taskCreator.createInitTaskDomain(request.getTaskName(), ticketDomain);
        UUID taskId = taskRepository.save(taskMapper.toEntity(taskDomain)).getId();
        return taskMapper.toTaskResponseInformation(taskId, taskDomain);
    }

    @Transactional
    @Override
    public UpdateTaskStatusResponseDTO updateTaskStatus(UUID task_id, String taskStatus, String updatedTime) {
        Task task = taskRepository.findById(task_id)
                .orElseThrow(() -> BaseException.createBaseExceptionWithoutDetail(HttpStatus.BAD_REQUEST,
                        "유효하지 않은 Task ID 입니다."));
        task.updateTaskStatus(TaskStatus.fromCodeName(taskStatus));
        restTaskEventListener.handleTaskStatusUpdateEvent(
                new TaskStatusUpdateEvent(task_id, task.getTicketId(), task.getTaskName(), taskStatus, updatedTime));
        Task updateTask = taskRepository.save(task);

        return new UpdateTaskStatusResponseDTO(
                updateTask.getId(),
                updateTask.getTaskStatus()
        );
    }
}
