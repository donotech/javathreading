package com.bdec.hero.spring_web.spring_security_rest.jwt_bearer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserRestController {

    @Autowired
    AuthenticationManager authenticationManager; //this is not required if we use a user repository

    @Autowired
    JWTUtils jwtUtils;

    @GetMapping("/authenticate")
    public String authenticate(@RequestParam String username, @RequestParam String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        String token = jwtUtils.generateToken(username);
        return token;
    }

    @GetMapping("/all")
    public String all() {
        return "all are welcome";
    }

   @GetMapping("/hello")
    public String helloUser() {
        String userPrincipal =
                (String) SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal();

        return "hello " + userPrincipal;
    }

    @GetMapping("/hellosecurity")
    public String helloUserWithPrincipal(Principal securityPrincipal) {
        String userPrincipal =
                securityPrincipal.getName();

        return "hello " + userPrincipal;
    }
}
