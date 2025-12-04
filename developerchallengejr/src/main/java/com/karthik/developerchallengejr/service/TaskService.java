package com.karthik.developerchallengejr.service;

import java.util.ArrayList;

import com.karthik.developerchallengejr.model.Task;

import jakarta.validation.Valid;

public interface TaskService {
    Task createTask(@Valid Task task);

	ArrayList<Task> getAllTasks();
}