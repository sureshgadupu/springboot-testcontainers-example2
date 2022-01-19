package dev.fullstackcode.tc.docker.it;


import dev.fullstackcode.tc.docker.entity.Department;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartmentControllerIT extends BaseIT {



    @Test
    @Sql({ "/import.sql" })
    public void testGetDepartmentById() {

        ResponseEntity<Department> response = testRestTemplate.getForEntity( "/department/{id}",Department.class,100);
        Department dept =  response.getBody();

        assertEquals(100,dept.getId());
        assertEquals("HR", dept.getName());

    }




}