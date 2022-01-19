package dev.fullstackcode.tc.docker.repository;



import dev.fullstackcode.tc.docker.entity.Employee;
import dev.fullstackcode.tc.docker.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface  EmployeeRepository extends JpaRepository<Employee,Integer> {

    public  List<Employee> findByGender(Gender gender);

    @Query("select e from Employee e where e.gender = 'M'")
    public  List<Employee> searchByGender(Gender gender);
}
