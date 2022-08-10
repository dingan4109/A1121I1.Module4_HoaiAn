package spring_casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_casestudy.entity.Contract;

@Repository
public interface ContractRepo extends JpaRepository<Contract,Integer> {
}
