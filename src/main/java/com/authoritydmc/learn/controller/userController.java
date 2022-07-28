package com.authoritydmc.learn.controller;

import com.authoritydmc.learn.Entity.User;
import com.authoritydmc.learn.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Controller
@ApiIgnore
@RequestMapping("/users")
public class userController {

    private final UserService userService;


    public userController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getUsers(Model model){

        List<User> usersList=userService.getUsers();

        model.addAttribute("usersList",usersList);

        return "userview";
    }

}
