package com.group10.bookingtravel.controller;

import antlr.collections.impl.LList;
import com.group10.bookingtravel.entity.User;
import com.group10.bookingtravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getListUserStatus(){
        return userService.getListUserStatus();
    }
}
