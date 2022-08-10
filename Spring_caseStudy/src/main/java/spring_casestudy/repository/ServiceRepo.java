package spring_casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_casestudy.entity.Service;
@Repository
public interface ServiceRepo extends JpaRepository<Service, Integer> {
}
