package com.SSD.SSD.controllers;

import com.SSD.SSD.model.Department;
import com.SSD.SSD.repos.DepartmentRepository;
import com.SSD.SSD.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/get")
    public List<Department> getDepartments(){

        System.out.println(departmentService.getDepartments());
        return departmentService.getDepartments();
    }

    @GetMapping("/save")
    public void run() {

        Department department = new Department();
        department.setName("WWW");
        System.out.println(department);

        departmentService.save(department);

        System.out.println("OK");
    }
    @GetMapping("/save2")
    public void ru2n() {

        Department department = new Department();
        department.setName("Wydział Informatyki");

        System.out.println(department);

        departmentService.save(department);

        System.out.println("OK");
    }
}
