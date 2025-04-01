package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {

    // // Find tasks by assigned employee
    // @Query("SELECT t FROM Task t WHERE t.assignedEmployee.id = :employeeId")
    // List<Task> findTasksByEmployee(@Param("employeeId") Long employeeId);

    // // Find tasks by status
    // List<Task> findByStatus(String status);

    // // Find overdue tasks
    // @Query("SELECT t FROM Task t WHERE t.dueDate < CURRENT_DATE")
    // List<Task> findOverdueTasks();
}
