package spring_casestudy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring_casestudy.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    @Query(value = "SELECT customer_name,attach_service_name," +
            "contract_detail_id" +
            " " +
            "FROM customer " +
            "INNER JOIN contract ON customer.customer_id = contract.customer_id " +
            "LEFT JOIN contract_detail ON contract.contract_id = contract_detail.contract_id " +
            "LEFT JOIN attach_service ON contract_detail.attach_service_id = attach_service.attach_service_id ",nativeQuery = true)
    Page<Customer> findAllCustomerUseService(Pageable pageable);
    @Query("select c from Customer as c where c.customerName like %?1% and c.customerAddress like %?2% and c.customerEmail like %?3%")
    Page<Customer> search(String name,String address, String email, Pageable pageable);
    Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerEmailContaining(String name,String address, String email, Pageable pageable);

}
