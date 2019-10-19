package com.j24.security.template.controller;

import com.j24.security.template.model.Account;
import com.j24.security.template.model.Machine;
import com.j24.security.template.service.AccountService;
import com.j24.security.template.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/machine")
public class MachineController {
    @Autowired
    private MachineService machineService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/list")
    public String getMachineList (Model model){
        List<Machine> machineList =machineService.getAll();
        model.addAttribute("machines", machineList);
        return "machines";
    }

}
