package shopping_cart.entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    //check product có tồn tại không
    private boolean checkItemInCart(Product product) {
        for(Map.Entry<Product,Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        } return false;
    }
    //find product
    private Map.Entry<Product,Integer> selectItemInCart(Product product) {
        for(Map.Entry<Product,Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        } return null;
    }
    //add
    public void addProduct(Product product) {
        if(!checkItemInCart(product)) {
            products.put(product,1);
        }else {
            Map.Entry<Product,Integer> entry = selectItemInCart(product);
            Integer newQuantity = entry.getValue() + 1;
            products.replace(entry.getKey(),newQuantity);
        }
    }

    //deduct
    public void deductProduct(Product product) {
        Map.Entry<Product,Integer> entry = selectItemInCart(product);
        Integer newQuantity = entry.getValue() - 1;
        products.replace(entry.getKey(),newQuantity);
    }

    //delete
    public void deleteProduct(Product product) {
        Map.Entry<Product,Integer> entry = selectItemInCart(product);
        products.remove(entry.getKey());
    }
    //count total quantity of all products in cart
    public Integer countProductQuantity() {
        Integer totalQuantity = 0;
        for(Map.Entry<Product,Integer> entry: products.entrySet()) {
            totalQuantity += entry.getValue();
        }
        return totalQuantity;
    }

    //count number of items in cart
    public Integer countItemQuantity() {
        return products.size();
    }

    //count total payment
    public Double countTotalPayment() {
        Double totalPayment = 0d;
        for(Map.Entry<Product,Integer> entry : products.entrySet()) {
            totalPayment += entry.getKey().getPrice() * entry.getValue();
        }
        return totalPayment;
    }
}
