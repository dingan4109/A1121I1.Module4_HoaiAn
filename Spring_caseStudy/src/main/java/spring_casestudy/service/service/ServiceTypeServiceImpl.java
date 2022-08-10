package spring_casestudy.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring_casestudy.entity.ServiceType;
import spring_casestudy.repository.ServiceTypeRepo;

import java.util.Optional;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService{
    @Autowired
    ServiceTypeRepo serviceTypeRepo;

    @Override
    public Page<ServiceType> findAll(Pageable pageable) {
        return serviceTypeRepo.findAll(pageable);
    }

    @Override
    public Optional<ServiceType> findById(int id) {
        return serviceTypeRepo.findById(id);
    }

    @Override
    public void save(ServiceType serviceType) {
        serviceTypeRepo.save(serviceType);
    }

    @Override
    public void deleteById(int id) {
        serviceTypeRepo.deleteById(id);
    }
}
