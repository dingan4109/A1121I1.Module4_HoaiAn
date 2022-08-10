package spring_casestudy.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring_casestudy.entity.Division;
import spring_casestudy.repository.DivisionRepo;

import java.util.Optional;

@Service
public class DivisionServiceImpl implements DivisionService{
    @Autowired
    DivisionRepo divisionRepo;
    @Override
    public Page<Division> findAll(Pageable pageable) {
        return divisionRepo.findAll(pageable);
    }

    @Override
    public Optional<Division> findById(int id) {
        return divisionRepo.findById(id);
    }

    @Override
    public void save(Division division) {
        divisionRepo.save(division);
    }

    @Override
    public void deleteById(int id) {
        divisionRepo.deleteById(id);
    }
}
