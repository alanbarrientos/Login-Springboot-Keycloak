package com.springkeycloak.demo.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TestController {

    @GetMapping("")
    public String landing(){
        return "Landing Page";
    }

    @GetMapping("/algo")
    public String algo(){
        return "algo";
    }

    @GetMapping("/successLogin")
    public String successLogin(){
        return "You have been succesfully loged in";
    }



    @GetMapping("/user")
    @RolesAllowed("admin") // to use test Roles
    public String userInfo(){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String userInfo = "";
//        if (auth != null) {
//            userInfo = userInfo + "--------Auth:    " + auth;
//        }
//        if (auth.getPrincipal() != null) {
//            userInfo = userInfo + "------Principal:  " + auth.getPrincipal();
//        }
//        Authentication auth =
//                SecurityContextHolder.getContext().getAuthentication();
//        userInfo = userInfo + "--------Roles:    ";
//        userInfo = userInfo + auth.getAuthorities().stream().map(e->e.getAuthority()).collect(Collectors.joining(","));
//        return userInfo;


        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();

        final List<String> authorities = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return authorities.toString();
    }

}
