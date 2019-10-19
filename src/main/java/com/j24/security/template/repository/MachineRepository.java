package com.j24.security.template.repository;

import com.j24.security.template.model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepository extends JpaRepository <Machine, Long> {
}
