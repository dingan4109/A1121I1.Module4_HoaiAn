package spring_casestudy.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring_casestudy.entity.Customer;
import spring_casestudy.service.GeneralService;

public interface CustomerService extends GeneralService<Customer> {
    Page<Customer> findAllCustomerUseService(Pageable pageable);
    Page<Customer> search(String name,String address, String email,Pageable pageable);
}
