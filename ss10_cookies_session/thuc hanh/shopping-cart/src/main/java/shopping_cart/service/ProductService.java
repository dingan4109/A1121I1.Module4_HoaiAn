package shopping_cart.service;

import shopping_cart.entity.Product;

import java.util.Optional;

public interface ProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
