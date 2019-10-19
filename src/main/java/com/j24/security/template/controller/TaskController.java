package com.j24.security.template.controller;

import com.j24.security.template.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;
}
