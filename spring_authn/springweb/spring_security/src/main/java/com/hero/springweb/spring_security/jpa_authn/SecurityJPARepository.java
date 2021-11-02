package com.hero.springweb.spring_security.jpa_authn;

import com.hero.springweb.spring_security.jpa_authn.JPAUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityJPARepository extends JpaRepository<JPAUserEntity, Integer> {
    public JPAUserEntity findByUserName(String userName);
}
