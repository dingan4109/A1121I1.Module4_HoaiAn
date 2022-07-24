package shopping_cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping_cart.entity.Product;
import shopping_cart.repository.ProductRepo;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepo productRepo;

    @Override
    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepo.findById(id);
    }
}
