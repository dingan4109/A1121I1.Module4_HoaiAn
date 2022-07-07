package customer_management.repository;

import customer_management.entity.Customer;

public interface CustomerRepo extends GeneralRepo<Customer> {
    void insertWithStoredProcedure(Customer customer);
}
