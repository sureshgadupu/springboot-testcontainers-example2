package dev.fullstackcode.tc.docker.controller;



import dev.fullstackcode.tc.docker.entity.Employee;
import dev.fullstackcode.tc.docker.entity.Gender;
import dev.fullstackcode.tc.docker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(value="/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        Employee emp = employeeService.getEmployeeById(id);
        System.out.println(emp.getId());
        return emp;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping(value="/gender/{gender}")
    public List<Employee> getEmployeesByGender(@PathVariable String gender) {

        return employeeService.findEmployeesByGender(Gender.valueOf(gender));
    }

    @GetMapping(value="/gender2/{gender}")
    public List<Employee> searchEmployeesByGender(@PathVariable String gender) {

        return employeeService.searchEmployeesByGender(Gender.valueOf(gender));
    }

}
