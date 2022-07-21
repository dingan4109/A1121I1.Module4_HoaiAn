package phone_validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import phone_validation.entity.PhoneNumber;

@Controller
public class PhoneController {
    @GetMapping("/")
    public String showForm(Model model) {
        PhoneNumber phoneNumber = new PhoneNumber();
        model.addAttribute("phoneNumber", phoneNumber);
        return "index";
    }

    @PostMapping("/")
    public String checkValidation(@ModelAttribute PhoneNumber phoneNumber, BindingResult bindingResult, Model model) {
        new PhoneNumber().validate(phoneNumber,bindingResult);
        if(bindingResult.hasErrors()) {
            return "index";
        }else {
            model.addAttribute("phoneNumber",phoneNumber);
            return "result";
        }
    }
}
