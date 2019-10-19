package com.j24.security.template.service;

import com.j24.security.template.model.Machine;
import com.j24.security.template.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {
    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAll() {
        return machineRepository.findAll();
    }
}
