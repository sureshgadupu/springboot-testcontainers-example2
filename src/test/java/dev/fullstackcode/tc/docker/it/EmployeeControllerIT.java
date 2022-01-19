package dev.fullstackcode.tc.docker.it;


import dev.fullstackcode.tc.docker.entity.Department;
import dev.fullstackcode.tc.docker.entity.Employee;
import dev.fullstackcode.tc.docker.entity.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeControllerIT extends BaseIT {


    @Test
    @Sql({ "/import.sql" })
    public void testCreateEmployee() {

        Department dept = new Department();
        dept.setId(100);

        Employee emp = new Employee();

        emp.setFirst_name("abc");
        emp.setLast_name("xyz");
        emp.setDepartment(dept);
        emp.setBirth_date(LocalDate.of(1980,11,11));
        emp.setHire_date(LocalDate.of(2020,01,01));
        emp.setGender(Gender.F);

        ResponseEntity<Employee> response = testRestTemplate.postForEntity( "/employee", emp, Employee.class);

        Employee employee =  response.getBody();

        assertNotNull(employee.getId());
        assertEquals("abc", employee.getFirst_name());

    }

    @Test
    @Sql({ "/import.sql" })
    public void testGetEmployeeById() {

        ResponseEntity<Employee> response = testRestTemplate.getForEntity( "/employee/{id}",Employee.class,100);
        Employee employee =  response.getBody();

        assertEquals(100,employee.getId());
        assertEquals("Alex", employee.getFirst_name());

    }

}