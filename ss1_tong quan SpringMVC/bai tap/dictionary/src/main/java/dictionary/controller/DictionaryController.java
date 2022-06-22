package dictionary.controller;

import dictionary.repository.DicMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {
    @Autowired
    private DicMap dicMap;

    @GetMapping
    public String redirectToHomepage() {
        return "homepage";
    }

    @PostMapping("/look-up")
    public ModelAndView lookup(@RequestParam String word) {
        ModelAndView modelAndView = new ModelAndView("homepage");
        String result = dicMap.getValue(word);
        if(result==null) {
            modelAndView.addObject("result","Result not found");
        }else {
            modelAndView.addObject("result",result);
        }
        modelAndView.addObject("word",word);
        return modelAndView;
    }
}
