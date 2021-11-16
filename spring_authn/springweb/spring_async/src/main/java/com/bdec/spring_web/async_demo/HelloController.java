package com.bdec.spring_web.async_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

@RestController
public class HelloController {

    @Autowired
    GitHubLookupService gitHubLookupService;

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/users_sync")
    public UserListAndTimings getUsersSync() throws Exception{
        long start = System.currentTimeMillis();
        User user1 = gitHubLookupService.findUserSync("PivotalSoftware");
        User user2 = gitHubLookupService.findUserSync("CloudFoundry");
        User user3 = gitHubLookupService.findUserSync("Spring-Projects");
        Long elapsedTime = (System.currentTimeMillis() - start);

        System.out.println("Elapsed time: " + elapsedTime);
        System.out.println("--> " + user1);
        System.out.println("--> " + user2);
        System.out.println("--> " + user3);
        UserListAndTimings response = new UserListAndTimings(
                Arrays.asList(user1, user2, user3),
                elapsedTime);
        return response;
    }

    @GetMapping("/users")
    public UserListAndTimings getUsers() throws Exception{
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<User> page1 = gitHubLookupService.findUser("PivotalSoftware");
        CompletableFuture<User> page2 = gitHubLookupService.findUser("CloudFoundry");
        CompletableFuture<User> page3 = gitHubLookupService.findUser("Spring-Projects");

        // Wait until they are all done
        CompletableFuture.allOf(page1,page2,page3).join();

        // Print results, including elapsed time

        User user1 = page1.get();
        User user2 = page2.get();
        User user3 = page3.get();
        Long elapsedTime = (System.currentTimeMillis() - start);

        System.out.println("Elapsed time: " + elapsedTime);
        System.out.println("--> " + user1);
        System.out.println("--> " + user2);
        System.out.println("--> " + user3);
        UserListAndTimings response = new UserListAndTimings(
                Arrays.asList(user1, user2, user3),
                elapsedTime);
        return response;
    }
}
