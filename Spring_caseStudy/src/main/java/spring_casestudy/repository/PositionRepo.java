package spring_casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_casestudy.entity.Position;
@Repository
public interface PositionRepo extends JpaRepository<Position,Integer> {
}
