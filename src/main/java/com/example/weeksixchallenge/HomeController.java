package com.example.weeksixchallenge;

import com.example.weeksixchallenge.AccountHolderRepository;
import com.example.weeksixchallenge.EmployeeRepository;
import com.example.weeksixchallenge.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String index(){
        return "form";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/list")
    public String listRooms(Model model) {
        model.addAttribute("accountholder", accountHolderRepository.findAll());
        return "list";
    }

    @GetMapping("/accountholder")
    public String addRoom(Model model){

        model.addAttribute("accountholder", new UserData ());

        return "form";

    }

    @PostMapping("/process")
    public String processForm(@Valid UserData userData, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }

        accountHolderRepository.save(userData);
        return "redirect:/accountholder";
    }

    @RequestMapping("/detail/{id}")
    public String showPet(@PathVariable("id") long id, Model model) {
        model.addAttribute("accountholder", accountHolderRepository.findOne(id));
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updatePet(@PathVariable("id") long id, Model model) {
        model.addAttribute("accountholder", accountHolderRepository.findOne(id));
        return "form";
    }
}
