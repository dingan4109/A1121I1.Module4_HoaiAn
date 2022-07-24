package shopping_cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shopping_cart.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
}
