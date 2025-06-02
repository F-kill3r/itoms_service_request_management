package com.capston_design.fkiller.itoms.service_request_management.service;

import com.capston_design.fkiller.itoms.service_request_management.controller.dto.request.CreateTasksRequestDTO;
import com.capston_design.fkiller.itoms.service_request_management.controller.dto.response.TaskResponseInformation;
import com.capston_design.fkiller.itoms.service_request_management.domain.entity.ticket_information.TicketInformation;
import com.capston_design.fkiller.itoms.service_request_management.domain.task.TaskCreator;
import com.capston_design.fkiller.itoms.service_request_management.domain.task.TaskDomain;
import com.capston_design.fkiller.itoms.service_request_management.domain.task.TaskMapper;
import com.capston_design.fkiller.itoms.service_request_management.domain.ticket.TicketDomain;
import com.capston_design.fkiller.itoms.service_request_management.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService{

    private final TicketInformationService ticketInformationService;
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
}
