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
import spring_casestudy.service.employee.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PositionService positionService;
    @Autowired
    DivisionService divisionService;
    @Autowired
    EducationDegreeService educationDegreeService;
    @Autowired
    UserService userService;

    @ModelAttribute("user")
    public User getUser(HttpServletRequest request) {
        User user = new User();
        user.setUsername(request.getUserPrincipal().getName());

        return user;
    }

    @ModelAttribute("positions")
    public Page<Position> listPosition(Pageable pageable) {
        return positionService.findAll(pageable);
    }
    @ModelAttribute("divisions")
    public Page<Division> listDivision(Pageable pageable) {
        return divisionService.findAll(pageable);
    }
    @ModelAttribute("educationDegrees")
    public Page<EducationDegree> listEducationDegree(Pageable pageable) {
        return educationDegreeService.findAll(pageable);
    }


    @GetMapping("list")
    public ModelAndView listEmployee(@PageableDefault(value = 5) Pageable pageable) {
        Page<Employee> employeeList = employeeService.findAll(pageable);
        return new ModelAndView("views/employee/list","employeeList",employeeList);
    }

    @GetMapping("create")
    public ModelAndView createForm() {
        return new ModelAndView("views/employee/createForm","employee",new Employee());
    }

    @PostMapping("create")
    public String create(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "views/employee/createForm";
        }else {
            User user = new User();
            user.setUsername(employee.getEmployeeEmail());
            user.setPassword("$2a$10$OBTxEe8n90PWGXUureVhi.gdzmZdrDSx/5bykDBLRrp18B2kkQZOy");
            userService.save(user);

            employee.setUser(user);
            employeeService.save(employee);
            return "redirect:/employees/list";
        }
    }
}
