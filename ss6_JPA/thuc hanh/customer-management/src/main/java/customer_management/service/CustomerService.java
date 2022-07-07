package customer_management.service;

import customer_management.entity.Customer;

public interface CustomerService extends GeneralService<Customer> {
    void insertWithStoredProcedure(Customer customer);
}
