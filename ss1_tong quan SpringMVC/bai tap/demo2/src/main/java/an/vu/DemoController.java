package an.vu;


import org.springframework.stereotype.Controller;

@Controller
public class DemoController {
    public String getHome(){
        return "xyz";
    }
}
