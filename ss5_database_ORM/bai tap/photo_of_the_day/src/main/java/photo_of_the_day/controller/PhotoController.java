package photo_of_the_day.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import photo_of_the_day.entity.Photo;
import photo_of_the_day.service.PhotoService;

@Controller
public class PhotoController {
    @Autowired
    PhotoService photoService;

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    @GetMapping("/showForm")
    public ModelAndView save(@RequestParam("photo-src") String src) {
        Photo photo = new Photo();
        photo.setPhotoLink(src);

        ModelAndView modelAndView = new ModelAndView("feedback");
        modelAndView.addObject("photo",photo);

        return modelAndView;
    }

    @PostMapping("save")
    public String save(@ModelAttribute("photo") Photo photo,RedirectAttributes redirectAttributes) {
        photoService.save(photo);
        redirectAttributes.addFlashAttribute("photo",photo);
        return "redirect:/home";
    }
}
