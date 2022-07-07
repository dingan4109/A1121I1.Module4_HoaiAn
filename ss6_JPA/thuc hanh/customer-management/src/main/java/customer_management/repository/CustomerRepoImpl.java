package customer_management.repository;

import customer_management.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CustomerRepoImpl implements CustomerRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        String hql = "SELECT c FROM Customer c";
        TypedQuery<Customer> query = entityManager.createQuery(hql,Customer.class);

        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        String hql = "SELECT c FROM Customer c WHERE c.id=:id";
        TypedQuery<Customer> query = entityManager.createQuery(hql,Customer.class).setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Customer customer) {
        if(customer.getId() == null) {
            entityManager.persist(customer);
        }else {
            entityManager.merge(customer);
        }
    }

    @Override
    public void remove(Long id) {
       Customer customer = findById(id);
       if(customer!=null) {
           entityManager.remove(customer);
       }
    }

    @Override
    public void insertWithStoredProcedure(Customer customer) {
        String sql = "CALL insert_customer(:firstName,:lastName)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("firstName",customer.getFirstName());
        query.setParameter("lastName",customer.getLastName());

        query.executeUpdate();
    }
}
