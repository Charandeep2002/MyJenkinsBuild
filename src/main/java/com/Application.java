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

                    h1 {
                        color: #38bdf8;
                    }

                    form {
                        margin-top: 30px;
                    }

                    input {
                        padding: 10px;
                        margin: 10px;
                        border-radius: 5px;
                        border: none;
                        width: 250px;
                    }

                    button {
                        padding: 10px 20px;
                        border: none;
                        border-radius: 5px;
                        background-color: #38bdf8;
                        color: #0f172a;
                        font-weight: bold;
                        cursor: pointer;
                    }

                    button:hover {
                        background-color: #0ea5e9;
                    }

                    #message {
                        margin-top: 20px;
                        font-size: 18px;
                        color: #22c55e;
                    }
                </style>
            </head>
            <body>

                <h1>🚀 Spring Boot App is now Testing Build</h1>

                <form onsubmit="handleSubmit(event)">
                    <div>
                        <input type="text" id="username" placeholder="Enter Username" required />
                    </div>
                    <div>
                        <input type="email" id="email" placeholder="Enter Email" required />
                    </div>
                    <button type="submit">Submit</button>
                </form>

                <div id="message"></div>

                <script>
                    function handleSubmit(event) {
                        event.preventDefault();

                        const username = document.getElementById("username").value;
                        const email = document.getElementById("email").value;

                        document.getElementById("message").innerText =
                            "✅ You have successfully entered the website, " + username + "!";
                    }
                </script>

            </body>
            </html>
        """;
    }
}
