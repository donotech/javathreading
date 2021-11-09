package com.hero.springweb.spring_security.jpa_authn;

import org.springframework.data.repository.CrudRepository;

public interface SecurityJPARepository extends CrudRepository<JPAUserEntity, Integer> {
    JPAUserEntity findByUserName(String userName);
}
