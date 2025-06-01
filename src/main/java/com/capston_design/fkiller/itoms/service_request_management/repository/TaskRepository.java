package com.capston_design.fkiller.itoms.service_request_management.repository;

import com.capston_design.fkiller.itoms.service_request_management.domain.entity.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

}
