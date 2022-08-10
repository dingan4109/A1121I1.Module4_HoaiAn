package spring_casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_casestudy.entity.Division;
@Repository
public interface DivisionRepo extends JpaRepository<Division,Integer> {
}
