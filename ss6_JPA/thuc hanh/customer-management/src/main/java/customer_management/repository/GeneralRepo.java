package customer_management.repository;

import java.util.List;

public interface GeneralRepo<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void remove(Long id);
}
