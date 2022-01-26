package com.project.professor.allocation.service;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departamentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departamentRepository = departmentRepository;
    }

    public Department findById(Long id) {
        Optional<Department> departmentOptional = departamentRepository.findById(id);
        Department department = departmentOptional.orElse(null);
        return department;
    }
}
