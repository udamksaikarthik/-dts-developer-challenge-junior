package com.karthik.developerchallengejr.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.karthik.developerchallengejr.model.Task;
import com.karthik.developerchallengejr.service.TaskService;

@Controller
public class TaskWebController {

	
	private final TaskService taskService;

    public TaskWebController(TaskService taskService) {
        this.taskService = taskService;
    }
	
    @GetMapping("/")
    public ModelAndView showTaskForm(Model model) {
    	ModelAndView mv = new ModelAndView();
        ArrayList<Task> response = taskService.getAllTasks();
        mv.addObject("tasks", response);
        mv.addObject("task", new Task());
        mv.setViewName("tasks.html");
        return mv;
    }
}
