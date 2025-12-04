package com.karthik.developerchallengejr.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.karthik.developerchallengejr.model.Task;
import com.karthik.developerchallengejr.service.TaskService;

import jakarta.validation.Valid;

@RestController
public class TaskRestController {

	@Autowired
    private TaskService taskService;

    @PostMapping("/api/tasks")
    public ModelAndView createTask(@Valid @ModelAttribute Task task,
            BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    	ModelAndView mv = new ModelAndView();
    	// If validation fails, return the form again
        if (bindingResult.hasErrors()) {
            mv.setViewName("tasks.html");
            ArrayList<Task> response = taskService.getAllTasks();
            mv.addObject("tasks", response);
            return mv;
        }
        Task savedTask = taskService.createTask(task);
        if(savedTask != null) {
            // Add flash attribute for success message
            redirectAttributes.addFlashAttribute("successMessage", "Task created successfully!");
        }else {
            redirectAttributes.addFlashAttribute("failureMessage", "Task not created successfully!");
        }
        mv.setViewName("redirect:/");
        return mv;
    }
}
