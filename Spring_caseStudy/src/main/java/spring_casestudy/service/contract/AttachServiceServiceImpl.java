package spring_casestudy.service.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring_casestudy.entity.AttachService;
import spring_casestudy.repository.AttachServiceRepo;

import java.util.Optional;

@Service
public class AttachServiceServiceImpl implements AttachServiceService{
    @Autowired
    AttachServiceRepo attachServiceRepo;

    @Override
    public Page<AttachService> findAll(Pageable pageable) {
        return attachServiceRepo.findAll(pageable);
    }

    @Override
    public Optional<AttachService> findById(int id) {
        return attachServiceRepo.findById(id);
    }

    @Override
    public void save(AttachService attachService) {
        attachServiceRepo.save(attachService);
    }

    @Override
    public void deleteById(int id) {
        attachServiceRepo.deleteById(id);
    }
}
