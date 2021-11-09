package com.bdec.hero.spring_web.spring_security_rest.basic_auth;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

//@RestController
public class UserController {

    @GetMapping("/home")
    public String getHome(){
        return "Home";
    }

    @GetMapping("/users")
    public String getUser(HttpServletRequest request, HttpServletResponse response){
        request.getRemoteUser();
        response.setHeader("Authorize: Bearer ", "tokenvalue");
        return "hello user";
    }

    @GetMapping("/me")
    public String getMe(Principal principal){
        return "hello user " + principal.getName();
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response, Authentication authentication){
        authentication.setAuthenticated(false);
        response.setHeader(HttpServletRequest.BASIC_AUTH,"");
        return "hello user " + authentication.getName() + " logged out";
    }

//    @GetMapping("/login")
//    public String login(@RequestParam String logout){
//        return logout;
//    }
}