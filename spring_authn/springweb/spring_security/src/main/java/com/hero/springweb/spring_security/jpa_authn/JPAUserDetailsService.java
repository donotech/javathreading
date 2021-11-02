package com.hero.springweb.spring_security.jpa_authn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class JPAUserDetailsService implements UserDetailsService {

    @Autowired
    SecurityJPARepository jpaRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //load from your repository the user details as per your storage entity
        JPAUserEntity jpaUserEntity = jpaRepository.findByUserName(username);
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getPassword() {
                return jpaUserEntity.getPassword();
            }

            @Override
            public String getUsername() {
                return jpaUserEntity.getUserName();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
        //return null; //JPA Implementation of your loadUserByUsername
    }

}
