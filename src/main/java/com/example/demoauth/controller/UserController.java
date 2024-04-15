package com.example.demoauth.controller;


import com.example.demoauth.entity.AuthRequest;

import com.example.demoauth.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import com.example.demoauth.service.JwtService;
import com.example.demoauth.service.UserInfoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserInfoService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }

    @DeleteMapping("removeUser/{id}")
    public void removeUser(@PathVariable int id){

        service.deleteUser(id);
    }
    /*@GetMapping("/getUsers")
    public List<UserInfo> getUsers(UserInfo userInfo){
        return UserInfoService.getUsers(userInfo);
    }*/
    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @PostMapping("/generateToken")
    public Map<String, String> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Map <String, String> params  = new HashMap<>();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            params.put("token",jwtService.generateToken(authRequest.getUsername()));
            return params;
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

}