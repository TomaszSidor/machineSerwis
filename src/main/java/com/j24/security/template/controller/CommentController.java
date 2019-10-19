package com.j24.security.template.controller;

import com.j24.security.template.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
}
