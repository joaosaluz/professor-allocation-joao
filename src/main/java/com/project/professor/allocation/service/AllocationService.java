package com.project.professor.allocation.service;

import com.project.professor.allocation.repository.AllocationRepository;
import com.project.professor.allocation.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class AllocationService {

    private AllocationRepository allocationRepository;

    public AllocationService(AllocationRepository allocationRepository){
        this.allocationRepository = allocationRepository;
    }
}
