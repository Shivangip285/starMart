package com.thoughtworks.starMart.Controller;

import com.thoughtworks.starMart.Model.Login;
import com.thoughtworks.starMart.Service.LoginLogoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class LoginLogoutController {
    private final LoginLogoutService loginLogoutService;

    public LoginLogoutController(LoginLogoutService loginLogoutService) {
        this.loginLogoutService = loginLogoutService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Login login){
       return ResponseEntity.ok().body(loginLogoutService.login(login));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser(){
        return ResponseEntity.ok().body(loginLogoutService.logout());
    }

    @PatchMapping("/changePassword")
    public ResponseEntity<String> changePassword(@RequestBody Login login){
        return ResponseEntity.ok().body(loginLogoutService.changePassword(login));
    }
}
