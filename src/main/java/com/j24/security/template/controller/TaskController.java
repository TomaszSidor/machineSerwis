package com.j24.security.template.controller;

import com.j24.security.template.model.Task;
import com.j24.security.template.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/list")
    public String getTaskList(Model model, @RequestParam(name = "machine") Long machineId) {
        List<Task> taskList = taskService.findAllTasksForMachineId(machineId);
        model.addAttribute("tasks", taskList);
        return "task-list";
    }

    @GetMapping("/add")
    public String getTaskForm(Model model, @RequestParam(name = "machine") Long machineId) {
        model.addAttribute("machineId", machineId);
        return "task-form";
    }

    @PostMapping("/add")
    public String addTask(Task task, Long machineId, Principal principal) {
        taskService.addTask(task, machineId, principal.getName());
        return "redirect:/task/list?machine=" + machineId;
    }
}
