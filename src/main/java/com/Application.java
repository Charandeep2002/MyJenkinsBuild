package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/")
    public String home() {
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>My App</title>
                <style>
                    body {
                        background-color: #0f172a;
                        color: #e2e8f0;
                        font-family: Arial;
                        text-align: center;
                        padding-top: 100px;
                    }
                    h1 { color: #38bdf8; }
                    p { color: #facc15; font-size: 20px; }
                </style>
            </head>
            <body>
                <h1>🚀 Spring Boot App</h1>
                <p>Your app is running successfully!</p>
            </body>
            </html>
        """;
    }
}
