package shopping_cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import shopping_cart.entity.Cart;

@Controller
public class CartController {
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("shopping-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        return new ModelAndView("cart","cart",cart);
    }
}
