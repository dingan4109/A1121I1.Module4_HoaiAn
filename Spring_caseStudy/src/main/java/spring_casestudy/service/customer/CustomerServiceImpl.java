package spring_casestudy.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring_casestudy.entity.Customer;
import spring_casestudy.repository.CustomerRepo;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepo.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void deleteById(int id) {
        customerRepo.deleteById(id);
    }

    @Override
    public Page<Customer> findAllCustomerUseService(Pageable pageable) {
        return customerRepo.findAllCustomerUseService(pageable);
    }

    @Override
    public Page<Customer> search(String name, String address, String email,Pageable pageable) {
        return customerRepo.findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerEmailContaining(name, address, email,pageable);
    }
}
