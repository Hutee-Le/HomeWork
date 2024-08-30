package vn.edu.likelion.SpringSecurity6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.SpringSecurity6.domain.dto.ResUserInfo;
import vn.edu.likelion.SpringSecurity6.domain.entity.UserEntity;
import vn.edu.likelion.SpringSecurity6.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserEntity register(@RequestBody UserEntity user) {
        return userService.registerUser(user);
    }

    @GetMapping("/info")
    public ResUserInfo userInfo() {
        return userService.getUserInfo();
    }
}