package com.authoritydmc.learn.Resources.api.v1;


import com.authoritydmc.learn.Entity.User;
import com.authoritydmc.learn.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
public class UserResource {
    private final UserService userService;


@Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("")
    public ResponseEntity<List<User>> Greet()
    {
        return ResponseEntity.ok(userService.getUsers());
    }


    @PostMapping("")
    public ResponseEntity<User> addUser(@RequestBody User user)
    {
        return ResponseEntity.ok(userService.insertUser(user));
    }
}
