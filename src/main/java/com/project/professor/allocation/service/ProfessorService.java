package com.project.professor.allocation.service;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private DepartmentService departmentService;

    public ProfessorService(ProfessorRepository professorRepository, DepartmentService departmentService) {
        this.professorRepository = professorRepository;
        this.departmentService = departmentService;
    }


    public Professor findById(Long id) {
        Optional<Professor> professorOptional = professorRepository.findById(id);
        Professor professor = professorOptional.orElse(null);
        return professor;
    }

    public List<Professor> findAll() {
        List<Professor> professor = professorRepository.findAll();
        return professor;
    }

    public Professor create(Professor professor) {
        professor.setId(null);
        Professor professorNew = saveInternal(professor);
        return professorNew;
    }

    public Professor update(Professor professor) {
        Long id = professor.getId();

        if (id != null && professorRepository.existsById(id)) {
            Professor professorNew = saveInternal(professor);
            return professorNew;
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        if (id != null && professorRepository.existsById(id)) {
            professorRepository.deleteById(id);
        }
    }

    public void deleteAll() {
        professorRepository.deleteAll();
    }

    private Professor saveInternal(Professor professor) {

            professor = professorRepository.save(professor);

            Department department = departmentService.findById(professor.getDepartmentId());
            professor.setDepartment(department);

            return professor;
    }
}