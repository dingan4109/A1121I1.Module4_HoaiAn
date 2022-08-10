package spring_casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring_casestudy.entity.*;
import spring_casestudy.service.service.RentTypeService;
import spring_casestudy.service.service.ServiceService;
import spring_casestudy.service.service.ServiceTypeService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/services")
public class ServiceController {
    @Autowired
    ServiceService serviceService;
    @Autowired
    ServiceTypeService serviceTypeService;
    @Autowired
    RentTypeService rentTypeService;

    @ModelAttribute("user")
    public User getUser(HttpServletRequest request) {
        User user = new User();
        user.setUsername(request.getUserPrincipal().getName());

        return user;
    }

    @ModelAttribute("serviceTypes")
    public Page<ServiceType> listServiceType(Pageable pageable) {
        return  serviceTypeService.findAll(pageable);
    }
    @ModelAttribute("rentTypes")
    public Page<RentType> listRentType(Pageable pageable) {
        return rentTypeService.findAll(pageable);
    }

    @GetMapping("/list")
    public ModelAndView listService(@PageableDefault(value = 3) Pageable pageable) {
        Page<Service> serviceList = serviceService.findAll(pageable);
        return new ModelAndView("views/service/list","serviceList",serviceList);
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        return new ModelAndView("views/service/createForm","service",new Service());
    }

    @PostMapping("/create")
    public String createCustomer(@Valid @ModelAttribute Service service, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "views/service/createForm";
        }else {
            serviceService.save(service);
            return "redirect:/services/create";
        }
    }

}
