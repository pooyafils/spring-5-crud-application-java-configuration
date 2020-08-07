package com.lov;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * pooya mahmoodi 8/7/2020
 **/
@Controller
public class WelcomeController {
    @RequestMapping("/")
    public  String home(){
        return "home";
    }
}
