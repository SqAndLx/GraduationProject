package com.graduation.controller;

import com.graduation.mode.User;
import com.graduation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/demo")
    public User index(@RequestParam(name = "id") String id ) {
        return userService.selectUserById(id);
    }
}
