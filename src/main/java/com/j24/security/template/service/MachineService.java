package com.j24.security.template.service;

import com.j24.security.template.model.Machine;
import com.j24.security.template.repository.AccountRepository;
import com.j24.security.template.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MachineService {
    @Autowired
    private MachineRepository machineRepository;
    @Autowired
    private AccountRepository accountRepository;

    public List<Machine> getAll() {
        return machineRepository.findAll();
    }

    public void addNew(Machine machine, String userName) {
        machine.setId(null);
        machine.setOwner(accountRepository.findByUsername(userName).get()); // Optional.get() otwiera pudełko optionala
        machineRepository.save(machine);
    }
}
