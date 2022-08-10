package spring_casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_casestudy.entity.EducationDegree;
@Repository
public interface EducationDegreeRepo extends JpaRepository<EducationDegree,Integer> {
}
