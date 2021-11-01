package com.hero.springweb.springweb;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;

@RestController()
@RequestMapping("jwtdemo")
public class JWTCookie {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/mypage")
    public String myPage(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(token != null && !token.isEmpty()) {
            token = token.substring(7);
            Jws<Claims> jws = Jwts.parser()
                    .setSigningKey(TextCodec.BASE64.decode("Extreeemly SecretKey"))
                    .parseClaimsJws(token);
            String username = (String) jws.getBody().get("user");
            String email = (String) jws.getBody().get("email");
            return "This is the page of " +
                    //request.getHeader(HttpHeaders.AUTHORIZATION)+
                    token + " user " + username + " email = " + email;
        }
        return "Invalid requested user";
    }

    @GetMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password, HttpServletResponse response) {
        if(username.equals(password)) {
            Calendar currentTimeNow = Calendar.getInstance();
            currentTimeNow.add(Calendar.MINUTE, 10);
            Date tenMinsFromNow = currentTimeNow.getTime();
            String token  = Jwts.builder()
                    .claim("user", username)
                    .claim("email", "devraj@bdec.in")
                    .setExpiration(tenMinsFromNow)
                    .signWith(SignatureAlgorithm.HS256,
                            TextCodec.BASE64.decode("Extreeemly SecretKey"))
                    .compact();

            response.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);

            return "<html><body><a href=\"/jwtdemo/mypage\">token set</a></html>";
        }
        return "invalid password";
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {

        return "logged out";
    }
}
