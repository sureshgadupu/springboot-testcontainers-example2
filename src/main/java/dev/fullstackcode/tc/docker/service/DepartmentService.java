package dev.fullstackcode.tc.docker.service;

import dev.fullstackcode.tc.docker.entity.Department;
import dev.fullstackcode.tc.docker.entity.Employee;
import dev.fullstackcode.tc.docker.repository.DepartmentRepository;
import dev.fullstackcode.tc.docker.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Integer id) {
        return departmentRepository.getById(id);
    }
}
