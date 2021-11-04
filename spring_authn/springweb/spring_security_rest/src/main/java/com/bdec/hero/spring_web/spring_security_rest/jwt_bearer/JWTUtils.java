package com.bdec.hero.spring_web.spring_security_rest.jwt_bearer;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;

@Component
public class JWTUtils {
    final static String secretKey = "Exteemly SecretKey";

    public boolean isValid(String token) {
        Jws<Claims> jws = Jwts.parser()
                .setSigningKey(TextCodec.BASE64.decode(secretKey))
                .parseClaimsJws(token);
        return jws.getBody().getExpiration().compareTo(new Date()) >= 0;
    }

    public static boolean isValid2(String token) {
        Jws<Claims> jws = Jwts.parser()
                .setSigningKey(TextCodec.BASE64.decode(secretKey))
                .parseClaimsJws(token);
        return jws.getBody().getExpiration().compareTo(new Date()) >= 0;
    }

    public String parseToken(String token) {
        Jws<Claims> jws = Jwts.parser()
                .setSigningKey(TextCodec.BASE64.decode(secretKey))
                .parseClaimsJws(token);
        String username = (String) jws.getBody().get("user");

        return username;
    }
    public static String parseToken2(String token) {
        Jws<Claims> jws = Jwts.parser()
                .setSigningKey(TextCodec.BASE64.decode(secretKey))
                .parseClaimsJws(token);
        String username = (String) jws.getBody().get("user");

        return username;
    }
    public String generateToken(String username) {

        Calendar currentTimeNow = Calendar.getInstance();
        currentTimeNow.add(Calendar.MINUTE, 10);
        Date tenMinsFromNow = currentTimeNow.getTime();
        String token = Jwts.builder()
                .setSubject(username)
                .claim("user", username)
                .setExpiration(tenMinsFromNow)
                .signWith(SignatureAlgorithm.HS256,
                        TextCodec.BASE64.decode(secretKey))
                .compact();

        return token;
    }

}
