package com.neweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController // This is a REST controller
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet() {
        GreetResponse response =  new GreetResponse(
                "Hello, World!",
                List.of("Java", "Kotlin", "Scala"),
                new Person("John", 20, 100_000)
        );
        return response;
    }

    record Person (
            String name,
            int age,
            double savings
    ) {}

    record GreetResponse(
            String message,
            List<String> favProgramingLanguages,
            Person person
    ) {}

//    class GreetResponse {
//        private String greet;
//
//        public GreetResponse(String message) {
//            this.greet = message;
//        }
//
//        public String getGreet() {
//            return greet;
//        }
//    }
}
