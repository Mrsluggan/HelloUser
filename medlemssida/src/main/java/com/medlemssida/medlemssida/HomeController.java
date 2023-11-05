package com.medlemssida.medlemssida;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {




    
    @GetMapping("/home")
    String getMembers(Model model) {
        return "home";
    }
}
