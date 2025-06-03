package com.capston_design.fkiller.itoms.service_request_management.validator;

import com.capston_design.fkiller.itoms.service_request_management.common.exception.BaseException;
import com.capston_design.fkiller.itoms.service_request_management.domain.entity.task.Task;
import com.capston_design.fkiller.itoms.service_request_management.domain.entity.task.TaskStatus;
import com.capston_design.fkiller.itoms.service_request_management.repository.TaskRepository;
import com.capston_design.fkiller.itoms.service_request_management.repository.TicketInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TaskValidator {
    private final TicketInformationRepository ticketInformationRepository;
    private final TaskRepository taskRepository;

    public boolean checkAllTaskCompleted(UUID ticketId){
        List<Task> taskList = taskRepository.findAllByTicketId(ticketId);
        if (taskList.isEmpty()) {
            throw BaseException.createBaseExceptionWithoutDetail(
                    HttpStatus.BAD_REQUEST, "해당 티켓에 할당된 작업이 없습니다.");
        }
        return taskList.stream()
                .allMatch(task -> task.getTaskStatus() == TaskStatus.COMPLETED);
    }


}
