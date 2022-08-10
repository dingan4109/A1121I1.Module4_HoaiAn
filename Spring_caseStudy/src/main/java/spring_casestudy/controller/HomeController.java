package spring_casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes("user")
public class HomeController {

    @GetMapping("/")
    public String getHome() {
        return "redirect:/customers/list";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("views/login");
    }
}
