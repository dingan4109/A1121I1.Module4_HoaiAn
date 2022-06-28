package data_binding.controller;

import data_binding.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @ModelAttribute
    public Employee getEmployee() {
        return new Employee();
    }
    @GetMapping("/show-form")
    public String view(ModelMap model) {
        return "create";
    }

    @PostMapping("/addEmployee")
    public String add(@ModelAttribute Employee employee,ModelMap model) {
        model.addAttribute("id",employee.getId());
        model.addAttribute("name",employee.getName());
        model.addAttribute("contactNumber",employee.getContactNumber());
        return "info";
    }
}
