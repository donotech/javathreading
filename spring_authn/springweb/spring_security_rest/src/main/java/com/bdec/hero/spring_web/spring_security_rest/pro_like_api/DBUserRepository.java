package com.bdec.hero.spring_web.spring_security_rest.pro_like_api;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DBUserRepository extends CrudRepository<DBUser, Integer> {
    Optional<DBUser> findByEmail(String email);
    Optional<DBUser> findByUserNameAndPassword(String userName, String password);
}
