package dev.fullstackcode.tc.docker.repository;



import dev.fullstackcode.tc.docker.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
