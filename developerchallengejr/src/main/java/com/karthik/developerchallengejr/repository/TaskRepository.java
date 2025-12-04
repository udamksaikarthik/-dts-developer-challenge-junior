package com.karthik.developerchallengejr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karthik.developerchallengejr.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
}
