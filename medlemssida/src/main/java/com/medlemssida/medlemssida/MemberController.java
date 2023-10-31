package com.medlemssida.medlemssida;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/members")
    String getMembers() {
        return "members";
    }


}
