package customer_management.service;

import customer_management.entity.Customer;
import customer_management.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepo customerRepo;
    @Override
    public Iterable<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepo.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepo.deleteById(id);
    }
}
