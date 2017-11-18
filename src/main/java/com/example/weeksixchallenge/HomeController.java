package com.example.weeksixchallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    UserDataRepository userDataRepository;

    @RequestMapping("/")
    public String form(){
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("accountholder", userInfoRepository.findAll());
        return "list";
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showRegistrationPage(Model model){
        model.addAttribute("accountholder", new UserInfo ());
        return "registration";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String processRegistrationPage(@Valid @ModelAttribute("accountholder") UserInfo user,
            BindingResult result,
            Model model){

        model.addAttribute("accountholder", user);

        if (result.hasErrors()) {
            return "registration";
        } else {
            userInfoRepository.save(user);
            model.addAttribute("message", "User Account Successfully Created");
        }
        return "login";
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
        System.out.println (userData.getId () );
        System.out.println (userData.getAcctNumber () );
        System.out.println (userData.getAction () );
        System.out.println (userData.getAmount () );
        System.out.println (userData.getReason () );
        userDataRepository.save(userData);
        return "redirect:/accountholder";
    }

    @RequestMapping("/detail/{id}")
    public String showAccount(@PathVariable("id") long id, Model model) {
        model.addAttribute("accountholder", userDataRepository.findOne(id));
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateAccount(@PathVariable("id") long id, Model model) {
        model.addAttribute("accountholder", userDataRepository.findOne(id));
        return "form";
    }
}
