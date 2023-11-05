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
        listOfMembers.add(new Member("Alice", 3));
        listOfMembers.add(new Member("Bob", 4));
        listOfMembers.add(new Member("Catherine", 5));
        listOfMembers.add(new Member("David", 6));
        listOfMembers.add(new Member("Eva", 7));
        listOfMembers.add(new Member("Frank", 8));
        listOfMembers.add(new Member("Grace", 9));
        listOfMembers.add(new Member("Hannah", 10));
        listOfMembers.add(new Member("Isaac", 11));
        listOfMembers.add(new Member("Jane", 12));
        listOfMembers.add(new Member("Karl", 13));
        listOfMembers.add(new Member("Linda", 14));
        listOfMembers.add(new Member("Michael", 15));

    }

    @GetMapping("/members")
    String getMembers(Model model) {
        model.addAttribute("listOfMembers", listOfMembers);

        return "members";
    }

    @GetMapping("/forms")
    String getForms(Model model) {
        model.addAttribute("listOfMembers", listOfMembers);

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
        return "redirect:/forms";

    }

}
