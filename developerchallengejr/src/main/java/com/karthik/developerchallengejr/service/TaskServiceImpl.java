package com.karthik.developerchallengejr.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.karthik.developerchallengejr.model.Task;
import com.karthik.developerchallengejr.repository.TaskRepository;

import jakarta.transaction.Transactional;

@Service
public class TaskServiceImpl implements TaskService {

	private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional
    public Task createTask(Task task) {

        Task saved = taskRepository.save(task);
        
        System.out.println("saved task: "+saved.toString());

        return saved;
    }

	@Override
	public ArrayList<Task> getAllTasks() {
		// TODO Auto-generated method stub
		 ArrayList<Task> tasks = (ArrayList<Task>) taskRepository.findAll();

	     return tasks;
	}
}