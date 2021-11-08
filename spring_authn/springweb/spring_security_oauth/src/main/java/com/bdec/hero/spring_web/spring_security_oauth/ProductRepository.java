package com.bdec.hero.spring_web.spring_security_oauth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
