package phone_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phone_management.entity.SmartPhone;
import phone_management.repository.SmartPhoneRepo;

import java.util.Optional;

@Service
public class SmartPhoneServiceImpl implements SmartPhoneService{
    @Autowired
    SmartPhoneRepo smartPhoneRepo;

    @Override
    public Iterable<SmartPhone> findAll() {
        return smartPhoneRepo.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return smartPhoneRepo.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
       return smartPhoneRepo.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        smartPhoneRepo.deleteById(id);
    }
}
