package spring_casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring_casestudy.entity.Customer;
import spring_casestudy.entity.CustomerType;
import spring_casestudy.entity.User;
import spring_casestudy.service.customer.CustomerService;
import spring_casestudy.service.customer.CustomerTypeService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerTypeService customerTypeService;

    @ModelAttribute("user")
    public User getUser(HttpServletRequest request) {
        User user = new User();
        user.setUsername(request.getUserPrincipal().getName());

        return user;
    }

    @ModelAttribute("customerTypeList")
    public Page<CustomerType> listCustomerType(Pageable pageable) {
        return customerTypeService.findAll(pageable);
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        return new ModelAndView("views/customer/createForm","customer",new Customer());
    }

    @PostMapping("/create")
    public String createCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "views/customer/createForm";
        }else {
            customerService.save(customer);
            return "redirect:/customers/list";
        }
    }

    @GetMapping("/list")
    public ModelAndView listCustomer(@PageableDefault(value = 5) Pageable pageable,
                                     @RequestParam("customerName") Optional<String> customerName,
                                     @RequestParam("customerAddress") Optional<String> customerAddress,
                                     @RequestParam("customerEmail") Optional<String> customerEmail) {
        Page<Customer> customerList;
        String condition = "";
        ModelAndView modelAndView = new ModelAndView("views/customer/list");
        if(customerName.isPresent() || customerAddress.isPresent() || customerEmail.isPresent()) {
            customerList = customerService.search(customerName.get(),customerAddress.get(),customerEmail.get(),pageable);
            if (customerName.isPresent()) {
                condition += "&customerName=" + customerName.get();
            }
            if (customerName.isPresent()) {
                condition += "&customerAddress=" + customerAddress.get();
            }
            if (customerName.isPresent()) {
                condition += "&customerEmail=" + customerEmail.get();
            }


        }else {
            customerList = customerService.findAll(pageable);
        }
        modelAndView.addObject("condition",condition);
        modelAndView.addObject("customerList",customerList);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable("id") int id) {
        Optional<Customer> customer = customerService.findById(id);
        if(customer.isPresent()) {
            return new ModelAndView("views/customer/editForm","customer",customer.get());
        }else {
            return new ModelAndView("views/customer/error-404");
        }
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute Customer customer, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "views/customer/editForm";
        }else {
            customerService.save(customer);
            return "redirect:/customers/list";
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteConfirm(@PathVariable("id") int id) {
        Optional<Customer> customer = customerService.findById(id);
        if(customer.isPresent()) {
            return new ModelAndView("views/customer/deleteConfirm","customer",customer.get());
        }else {
            return new ModelAndView("views/customer/error-404");
        }
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("deleteId") int id) {
        customerService.deleteById(id);
        return "redirect:/customers/list";
    }

    @GetMapping("customerUseService")
    public ModelAndView customerUseService(Pageable pageable) {
        Page<Customer> customerList = customerService.findAllCustomerUseService(pageable);
        return new ModelAndView("views/customer/customerUseService");
    }


}
