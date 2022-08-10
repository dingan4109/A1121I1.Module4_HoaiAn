package spring_casestudy.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring_casestudy.entity.Position;
import spring_casestudy.repository.PositionRepo;

import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    PositionRepo positionRepo;
    @Override
    public Page<Position> findAll(Pageable pageable) {
        return positionRepo.findAll(pageable);
    }

    @Override
    public Optional<Position> findById(int id) {
        return positionRepo.findById(id);
    }

    @Override
    public void save(Position position) {
        positionRepo.save(position);
    }

    @Override
    public void deleteById(int id) {
        positionRepo.deleteById(id);
    }
}
