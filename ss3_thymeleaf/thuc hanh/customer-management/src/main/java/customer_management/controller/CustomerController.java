package customer_management.controller;


import customer_management.model.Customer;
import customer_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers",customers);

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirectAttributes) {
        customer.setId((int) (Math.random()*1000));
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success","Created customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(Customer customer,RedirectAttributes redirectAttributes) {
        customerService.update(customer.getId(),customer);
        redirectAttributes.addFlashAttribute("success", "Edited customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable int id, ModelAndView modelAndView) {
        modelAndView = new ModelAndView("delete");
        Customer customer = customerService.findById(id);
        modelAndView.addObject("customer",customer);

        return modelAndView;

    }

    @PostMapping("/delete")
    public String remove(Customer customer,RedirectAttributes redirectAttributes) {
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("success","Deleted customer successfully!");

        return "redirect:/customer";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer",customerService.findById(id));

        return "view";
    }
}
