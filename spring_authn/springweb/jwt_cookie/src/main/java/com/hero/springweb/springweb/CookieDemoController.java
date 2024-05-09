package com.hero.springweb.springweb;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("unused")
@RestController()
@RequestMapping("cookiedemo")
public class CookieDemoController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/mypage")
    public String myPage(@CookieValue(value = "UserNAme") String username) {
        return "This is the page of " + username;
    }

    @GetMapping("/mypage2")
    public String myPage2(HttpServletRequest request) {
        Cookie[] cookie = request.getCookies();
        String username = null;
        for(int i = 0; i< cookie.length; i++) {
            Cookie c = cookie[i];
            if(c.getName() == "user") {
                c.getValue();
                username = c.getValue();
            }
        }
        return "This is the page of " + username;
    }


    @GetMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password, HttpServletResponse response) {
        if(username.equals(password)) {
            Cookie cookie = new Cookie("UserNAme", username);
            cookie.setMaxAge(120);
            response.addCookie(cookie);
            return "Cookie set";
        }
        return "invalid password";
    }

    @GetMapping("/logout")
    public String logout(@CookieValue(name = "user") String username, HttpServletResponse response) {
        Cookie cookie = new Cookie("user", username);
        cookie.setMaxAge(0); //setting age to 0 effectively invalidates the cookie
        response.addCookie(cookie);
        return "logged out";
    }
}
