package com.medlemssida.medlemssida;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    private static final List<Member> listOfMembers = new ArrayList<>();

    static {
        listOfMembers.add(new Member("Eric", 1));
        listOfMembers.add(new Member("Börje", 2));

    }

    @GetMapping("/members")
    String getMembers(Model model) {
        model.addAttribute("listOfMembers", listOfMembers);

        return "members";
    }

    @GetMapping("/forms")
    String getForms(Model model) {
        model.addAttribute("newMember", new Member(null, 0));
        return "forms";
    }

    @PostMapping("/newMember")
    String addMember(@RequestParam("name") String name) {
        listOfMembers.add(new Member(name, listOfMembers.size() + 1));
        return "redirect:/members";

    }

    @GetMapping("/removeMember/{memberId}")
    String removeMember(@PathVariable int memberId) {
        System.out.println("ta bort" + memberId);
        listOfMembers.removeIf(member -> member.getId() == memberId);
        return "redirect:/members";

    }

}
