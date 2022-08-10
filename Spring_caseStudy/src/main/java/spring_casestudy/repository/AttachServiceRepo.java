package spring_casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_casestudy.entity.AttachService;
@Repository
public interface AttachServiceRepo extends JpaRepository<AttachService,Integer> {
}
