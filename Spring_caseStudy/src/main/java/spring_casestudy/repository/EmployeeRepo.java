package spring_casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_casestudy.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}