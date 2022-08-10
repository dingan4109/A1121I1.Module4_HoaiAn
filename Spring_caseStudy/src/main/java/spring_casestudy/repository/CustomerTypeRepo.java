package spring_casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_casestudy.entity.CustomerType;
@Repository
public interface CustomerTypeRepo extends JpaRepository<CustomerType,Integer> {
}
