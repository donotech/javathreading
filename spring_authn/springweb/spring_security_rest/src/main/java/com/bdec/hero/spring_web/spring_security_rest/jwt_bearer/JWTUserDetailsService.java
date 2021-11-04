package com.bdec.hero.spring_web.spring_security_rest.jwt_bearer;

import com.bdec.hero.spring_web.spring_security_rest.pro_like_api.DBUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class JWTUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Called user details service for " + username);
        return new User(
                "user", "user",
                Arrays.asList(new SimpleGrantedAuthority("USER")));
    }
}
