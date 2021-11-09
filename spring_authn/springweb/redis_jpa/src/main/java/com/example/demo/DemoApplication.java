package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	SessionRepository sessionRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Session session1 = new Session(1,
				"SomeRandomString", new Date());
		Session session2 = new Session(2,
				"SomeRandomString2", new Date());
		sessionRepository.save(session1);
		sessionRepository.save(session2);

		Optional<Session> out1 = sessionRepository.findById(2);
		System.out.println(out1.get());

	}
}
