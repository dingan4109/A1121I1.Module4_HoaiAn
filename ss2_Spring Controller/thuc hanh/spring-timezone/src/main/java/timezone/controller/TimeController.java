package timezone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/world-clock")
    public String getTimeByTimeZone(Model model, @RequestParam (name = "city",required = false,
            defaultValue = "Asia/Ho_Chi_Minh") String city) {
        //get current time
        Date date = new Date();
        // get current timezone
        TimeZone local = TimeZone.getDefault();
        //get specified city's timezone
        TimeZone locale = TimeZone.getTimeZone(city);
        // calculate specified time of specified city
        long locale_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        // set time of variable date to current time of a city
        date.setTime(locale_time);

        model.addAttribute("city",city);
        model.addAttribute("date",date);
        return "index";
    }
}
