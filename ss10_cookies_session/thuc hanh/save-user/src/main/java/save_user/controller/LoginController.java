package save_user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import save_user.entity.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @RequestMapping("/login")
    public String index(@CookieValue(value = "setUser",defaultValue = "") String setUser, Model model) {
        Cookie cookie = new Cookie("setUser",setUser);
        model.addAttribute("cookieValue",cookie);
        return "login";
    }
    @PostMapping("/dologin")
    public String doLogin(@ModelAttribute("user") User user, Model model, @CookieValue(value = "setUser",defaultValue = "") String setUser, HttpServletRequest request, HttpServletResponse response) {
        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("12345")) {
                setUser = user.getEmail();

                Cookie cookie = new Cookie("setUser", setUser);
                cookie.setMaxAge(60 * 60 * 24);
                response.addCookie(cookie);
                model.addAttribute("cookieValue", cookie);

//                //get all cookies
//                Cookie[] cookies = request.getCookies();
//                //iterate each cookie
//                for (Cookie ck : cookies) {
//                    //display only the cookie with the name 'setUser'
//                    if (ck.getName().equals("setUser")) {
//                        model.addAttribute("cookieValue", ck);
//                        break;
//                    } else {
//                        ck.setValue("");
//                        model.addAttribute("cookieValue", ck);
//                        break;
//                    }
//                }
                model.addAttribute("message", "Login success. Welcome ");
            } else {
                user.setEmail("");
                Cookie cookie = new Cookie("setUser", setUser);
                model.addAttribute("cookieValue", cookie);
                model.addAttribute("message", "Login failed. Try again.");
            }
            return "login";
        }

}
