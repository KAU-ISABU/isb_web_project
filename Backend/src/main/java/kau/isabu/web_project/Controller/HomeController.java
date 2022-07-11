package kau.isabu.web_project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")//domain 첫번째를 의미
    public String home(){
        return "home";
    }
}
