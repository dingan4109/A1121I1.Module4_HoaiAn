package spring_casestudy.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring_casestudy.repository.ServiceRepo;

import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceService{
    @Autowired
    ServiceRepo serviceRepo;

    @Override
    public Page<spring_casestudy.entity.Service> findAll(Pageable pageable) {
        return serviceRepo.findAll(pageable);
    }

    @Override
    public Optional<spring_casestudy.entity.Service> findById(int id) {
        return serviceRepo.findById(id);
    }

    @Override
    public void save(spring_casestudy.entity.Service service) {
        serviceRepo.save(service);
    }

    @Override
    public void deleteById(int id) {
        serviceRepo.deleteById(id);
    }
}
