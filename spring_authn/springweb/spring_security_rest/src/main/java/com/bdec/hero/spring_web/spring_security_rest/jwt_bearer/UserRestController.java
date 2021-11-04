package com.bdec.hero.spring_web.spring_security_rest.jwt_bearer;
import com.bdec.hero.spring_web.spring_security_rest.pro_like_api.DBUser;
import com.bdec.hero.spring_web.spring_security_rest.pro_like_api.DBUserRepository;
import com.sun.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

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
}
