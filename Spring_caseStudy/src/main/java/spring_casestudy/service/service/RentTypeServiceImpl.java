package spring_casestudy.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring_casestudy.entity.RentType;
import spring_casestudy.repository.RentTypeRepo;

import java.util.Optional;
@Service
public class RentTypeServiceImpl implements RentTypeService{
    @Autowired
    RentTypeRepo rentTypeRepo;

    @Override
    public Page<RentType> findAll(Pageable pageable) {
        return rentTypeRepo.findAll(pageable);
    }

    @Override
    public Optional<RentType> findById(int id) {
        return rentTypeRepo.findById(id);
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepo.save(rentType);
    }

    @Override
    public void deleteById(int id) {
        rentTypeRepo.deleteById(id);
    }
}
