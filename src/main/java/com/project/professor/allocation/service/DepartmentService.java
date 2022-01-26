package com.project.professor.allocation.service;

import com.project.professor.allocation.repository.CourseRepository;
import com.project.professor.allocation.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository courseRepository;

    public DepartmentService(DepartmentRepository departmentRepository){
        this.courseRepository = departmentRepository;
    }
}
