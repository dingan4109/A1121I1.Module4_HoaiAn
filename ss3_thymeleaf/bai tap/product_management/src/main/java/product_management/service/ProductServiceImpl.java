package product_management.service;

import product_management.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    private List<Product> products = new ArrayList<>();
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(String id) {
        for(Product product : products) {
            if(product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product findByName(String name) {
        for(Product product : products) {
            if(product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(String id, Product product) {
        for(int i = 0;i<products.size();i++) {
            if(products.get(i).getId().equals(id)) {
                products.set(i,product);
            }
        }
    }

    @Override
    public void remove(Product product) {
        products.remove(product);
    }
}
