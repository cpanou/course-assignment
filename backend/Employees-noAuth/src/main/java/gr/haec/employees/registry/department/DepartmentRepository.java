package gr.haec.employees.registry.department;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findAllBySector(String sector);
}

