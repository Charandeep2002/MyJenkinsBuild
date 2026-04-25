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
                    font-family: Arial, sans-serif;
                    text-align: center;
                    padding-top: 100px;
                }
                h1 {
                    color: #38bdf8;
                }
                p {
                    font-size: 20px;
                    color: #facc15;
                }
                .box {
                    border: 2px solid #38bdf8;
                    padding: 20px;
                    display: inline-block;
                    border-radius: 10px;
                    background-color: #1e293b;
                }
            </style>
        </head>
        <body>
            <div class="box">
                <h1>🚀 My Spring Boot App</h1>
                <p>Hello, your JAR web app is running!</p>
            </div>
        </body>
        </html>
    """;
}
