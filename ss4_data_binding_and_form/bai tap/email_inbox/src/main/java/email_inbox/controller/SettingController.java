package email_inbox.controller;

import email_inbox.SettingDAO.SettingDAO;
import email_inbox.SettingDAO.SettingDAOImpl;
import email_inbox.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SettingController {
    SettingDAO settingDAO = new SettingDAOImpl();

    @GetMapping("/form")
    public ModelAndView getForm() {
        Setting setting = new Setting();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("setting",setting);
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("setting") Setting setting, RedirectAttributes redirectAtt) {
        settingDAO.saveSetting(setting);

        redirectAtt.addAttribute("lang",setting.getLanguage());
        return "redirect:/getSetting/{lang}";
    }

    @GetMapping("/getSetting/{lang}")
    public ModelAndView get(@PathVariable String lang) {

        Setting setting = settingDAO.getSetting(lang);
        ModelAndView modelAndView = new ModelAndView("result");
        if(setting!=null) {
            modelAndView.addObject("mess","Email's setting successfully saved");
            modelAndView.addObject("setting",setting);
        }else {
            modelAndView.addObject("mess","Fail to save email's setting");
        }
        return modelAndView;
    }

}
