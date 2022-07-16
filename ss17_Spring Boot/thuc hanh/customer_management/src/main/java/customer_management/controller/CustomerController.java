package customer_management.controller;

import customer_management.entity.Customer;
import customer_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/create")
    public ModelAndView createForm() {
        Customer customer = new Customer();
        return new ModelAndView("create","customer",customer);
    }

    @PostMapping("/create")
    public ModelAndView save(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer",new Customer());
        modelAndView.addObject("mess","New customer created successfully");

        return modelAndView;
    }

    @GetMapping("/customers")
    public ModelAndView listCustomers() {
        Iterable<Customer> customerList = customerService.findAll();
        return new ModelAndView("list","customerList",customerList);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if(customer.isPresent()) {
            return new ModelAndView("edit","customer",customer.get());
        }else {
            return new ModelAndView("error-404");
        }
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if(customer.isPresent()) {
            return new ModelAndView("delete","customer",customer.get());
        }else {
            return new ModelAndView("error-404");
        }
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("customer") Customer customer) {
        customerService.remove(customer.getId());

        return "redirect:/customers";
    }
}
