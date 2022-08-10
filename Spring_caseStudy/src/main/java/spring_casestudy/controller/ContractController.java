package spring_casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring_casestudy.entity.*;
import spring_casestudy.service.contract.AttachServiceService;
import spring_casestudy.service.contract.ContractDetailService;
import spring_casestudy.service.contract.ContractService;
import spring_casestudy.service.customer.CustomerService;
import spring_casestudy.service.employee.EmployeeService;
import spring_casestudy.service.service.ServiceService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("contracts")
public class ContractController {
    @Autowired
    ContractService contractService;
    @Autowired
    EmployeeService employeeService;
    @ModelAttribute("employees")
    public Page<Employee> listEmployee(Pageable pageable) {
        return employeeService.findAll(pageable);
    }
    @Autowired
    CustomerService customerService;
    @ModelAttribute("customers")
    public Page<Customer> listCustomer(Pageable pageable) {
        return customerService.findAll(pageable);
    }
    @Autowired
    ServiceService serviceService;
    @ModelAttribute("services")
    public Page<Service> listService(Pageable pageable) {
        return serviceService.findAll(pageable);
    }
    @Autowired
    ContractDetailService contractDetailService;
    @Autowired
    AttachServiceService attachServiceService;


    @ModelAttribute("user")
    public User getUser(HttpServletRequest request) {
        User user = new User();
        user.setUsername(request.getUserPrincipal().getName());

        return user;
    }

    @GetMapping
    public ModelAndView createForm() {
        return new ModelAndView("views/contract/createForm","contract",new Contract());
    }
    @PostMapping("create")
    public String saveContract(@Valid @ModelAttribute Contract contract, BindingResult bindingResult) {
        new Contract().validate(contract,bindingResult);
        if(bindingResult.hasErrors()) {
            return "views/contract/createForm";
        }else {
            contractService.save(contract);
            return "redirect:/customers/list";
        }
    }
    @GetMapping("contractDetail")
    public ModelAndView createContractDetailForm(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("views/contract/createContractDetailForm");
        Page<AttachService> attachServices = attachServiceService.findAll(pageable);
        Page<Contract> contracts = contractService.findAll(pageable);
        modelAndView.addObject("contractDetail",new ContractDetail());
        modelAndView.addObject("attachServices",attachServices);
        modelAndView.addObject("contracts",contracts);

        return modelAndView;
    }
    @PostMapping("createContractDetail")
    public String saveContractDetail(@Valid @ModelAttribute ContractDetail contractDetail, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "views/contract/createContractDetailForm";
        }else {
            contractDetailService.save(contractDetail);
            return "redirect:/customers/list";
        }
    }
}
