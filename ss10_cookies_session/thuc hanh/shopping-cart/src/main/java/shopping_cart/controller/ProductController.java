package shopping_cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import shopping_cart.entity.Cart;
import shopping_cart.entity.Product;
import shopping_cart.service.ProductService;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("shop")
    public ModelAndView showShop() {
        Iterable<Product> productList = productService.findAll();
        return new ModelAndView("shop","productList",productList);
    }

    @GetMapping("add/{id}")
    public String addToCard(@PathVariable("id") Long id, @ModelAttribute("cart") Cart cart, @RequestParam("action") String action) {
        Optional<Product> product = productService.findById(id);
        if(!product.isPresent()) {
            return "error-404";
        }
        if(action.equals("show")) {
            cart.addProduct(product.get());
            return "redirect:/shopping-cart";
        }
        if(action.equals("deduct")) {
            cart.deductProduct(product.get());
            return "redirect:/shopping-cart";
        }
        if(action.equals("delete")) {
            cart.deleteProduct(product.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product.get());
        return "redirect:/shop";
    }
    @GetMapping("view/{id}")
    public ModelAndView viewDetail(@PathVariable("id") Long id) {
        Optional<Product> product = productService.findById(id);
        if(!product.isPresent()) {
            return new ModelAndView("error-404");
        }
        return new ModelAndView("detail","product",product.get());
    }
}
