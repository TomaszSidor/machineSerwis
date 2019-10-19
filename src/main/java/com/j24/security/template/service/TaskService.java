package com.j24.security.template.service;

import com.j24.security.template.model.Account;
import com.j24.security.template.model.Machine;
import com.j24.security.template.model.Task;
import com.j24.security.template.repository.MachineRepository;
import com.j24.security.template.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private MachineRepository machineRepository;

    public List<Task> findAllTasksForMachineId(Long machineId) {
        List<Task> taskList = new ArrayList<>();
        Optional<Machine> taskOptional = machineRepository.findById(machineId);

        if(taskOptional.isPresent()) {
            taskList.addAll(taskOptional.get().getTasks());
        }
        return taskList;
    }

    public void addTask(Task task, Long machineId, String userName) {
        task.setId(null);
        task.setMachine(machineRepository.getOne(machineId));
        taskRepository.save(task);
    }
}
