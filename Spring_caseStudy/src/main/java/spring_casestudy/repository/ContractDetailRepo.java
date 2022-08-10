package spring_casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_casestudy.entity.ContractDetail;
@Repository
public interface ContractDetailRepo extends JpaRepository<ContractDetail,Integer> {
}
