package spring_casestudy.service.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring_casestudy.entity.ContractDetail;
import spring_casestudy.repository.ContractDetailRepo;

import java.util.Optional;

@Service
public class ContractDetailServiceImpl implements ContractDetailService{
    @Autowired
    ContractDetailRepo contractDetailRepo;

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepo.findAll(pageable);
    }

    @Override
    public Optional<ContractDetail> findById(int id) {
        return contractDetailRepo.findById(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepo.save(contractDetail);
    }

    @Override
    public void deleteById(int id) {
        contractDetailRepo.deleteById(id);
    }
}
