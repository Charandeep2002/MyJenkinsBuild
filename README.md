📄 ✅ README (Step-by-step + Image placeholders)
# 🚀 CI/CD Setup using AWS EC2, Jenkins & Spring Boot

This project demonstrates how to set up a basic CI/CD workflow using Jenkins Freestyle jobs to build and deploy a Spring Boot application on AWS EC2.

---

# 📌 1. Launch AWS EC2 Instance

- Created an Ubuntu EC2 instance from AWS console
- Configured instance type (t2.micro)
- Created key pair for SSH access

## 📸 Screenshot
![EC2 Instance](images/ec2-instance.png)

---

# 🔐 2. Configure Security Group

Added inbound rules:
- Port 22 (SSH)
- Port 8080 (Jenkins)
- Port 9090 (Application)

## 📸 Screenshot
![Security Group](images/security-group.png)

---

# 🔑 3. Connect to EC2 via SSH

```bash
chmod 400 your-key.pem
ssh -i your-key.pem ubuntu@<EC2-PUBLIC-IP>
📸 Screenshot


⚙️ 4. Update System
sudo apt update && sudo apt upgrade -y
☕ 5. Install Java 21
sudo apt install openjdk-21-jdk -y

Verify:

java -version
javac -version
📸 Screenshot

📦 6. Install Maven
sudo apt install maven -y

Verify:

mvn -version
📸 Screenshot

🔧 7. Install Jenkins
sudo apt install fontconfig openjdk-17-jre -y
sudo wget -O /usr/share/keyrings/jenkins-keyring.asc \
https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key
echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
/etc/apt/sources.list.d/jenkins.list > /dev/null
sudo apt update
sudo apt install jenkins -y

Start Jenkins:

sudo systemctl start jenkins
sudo systemctl enable jenkins
📸 Screenshot

🌐 8. Access Jenkins

Open in browser:

http://<EC2-PUBLIC-IP>:8080
📸 Screenshot

🔑 9. Unlock Jenkins
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
📸 Screenshot

🔗 10. Connect Jenkins to GitHub (Private Repo)
Generated GitHub Personal Access Token
Added credentials in Jenkins
📸 Screenshot

🔄 11. Configure GitHub Webhook
Added webhook in GitHub repository:
http://<EC2-PUBLIC-IP>:8080/github-webhook/
📸 Screenshot

⚙️ 12. Create Jenkins Freestyle Project
Created new job: jenkins-build
Selected Freestyle Project
📸 Screenshot

🔧 13. Configure Jenkins Job
Source Code Management:
Added GitHub repository URL
Selected credentials
Build Trigger:
Enabled GitHub webhook trigger
Build Step:
mvn clean install
📸 Screenshot

🚀 14. Run Build
Clicked "Build Now"
Verified build success in console
📸 Screenshot

📦 15. Run Application
java -jar target/demo-1.0.jar --server.port=9090
📸 Screenshot

🌐 16. Access Application
http://<EC2-PUBLIC-IP>:9090
📸 Screenshot
