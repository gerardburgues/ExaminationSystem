package com.SSD.SSD.services;

import com.SSD.SSD.model.Department;
import com.SSD.SSD.repos.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getDepartments() {

        return departmentRepository.findAll();
    }

    public void saveDepartment(Department department){

        departmentRepository.save(department);
    }
}
