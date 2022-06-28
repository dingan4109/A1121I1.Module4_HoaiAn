package user_login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import user_login.model.Login;
import user_login.model.User;
import user_login.repository.UserRepo;

@Controller
public class UserController {
    @GetMapping("/home")
    public ModelAndView home() {
        Login login = new Login();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("login", login);

        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login) {
        ModelAndView modelAndView;
        User user = UserRepo.checkLogin(login);

        if(user == null) {
            modelAndView = new ModelAndView("error");
        }else {
            modelAndView = new ModelAndView("user");
            modelAndView.addObject("user",user);
        }
        return modelAndView;
    }
}
