package spring_casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_casestudy.entity.ServiceType;

@Repository
public interface ServiceTypeRepo extends JpaRepository<ServiceType,Integer> {
}
