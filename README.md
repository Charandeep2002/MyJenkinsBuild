📄 ✅ Complete README (Step-by-Step CI/CD using AWS + Jenkins + GitHub)
# 🚀 End-to-End CI/CD Setup using AWS EC2, Jenkins & Spring Boot

This guide explains how to set up a complete build automation workflow using AWS EC2, Jenkins, Maven, and GitHub (private repo).

---

# 📌 1. Launch AWS EC2 Instance

1. Go to AWS Console → EC2 → Launch Instance
2. Configure:
   - Name: my-jenkins-server
   - AMI: Ubuntu (22.04 LTS)
   - Instance Type: t2.micro (Free Tier)
   - Key Pair: Create or select existing
   - Storage: Default (8GB)

  

3. Security Group → Add Inbound Rules:
   - SSH → Port 22 → My IP
   - HTTP → Port 80 → Anywhere
   - Custom TCP → Port 8080 → Anywhere (Jenkins)
   - Custom TCP → Port 9090 → Anywhere (Spring Boot App)
<img width="1907" height="905" alt="SG" src="https://github.com/user-attachments/assets/37c0eeae-1a55-4c54-814d-fc671291a5c3" />


4. Launch instance


<img width="1917" height="922" alt="EC2 instance" src="https://github.com/user-attachments/assets/b0f148e6-cdab-4e3d-a121-f21a5392cd88" />


---

# 🔐 2. Connect to EC2 via SSH
From your local machine:
```bash
chmod 400 your-key.pem
ssh -i your-key.pem ubuntu@<EC2-PUBLIC-IP>


# ⚙️ 3. Update System 

sudo apt update && sudo apt upgrade -y

☕ 4. Install Java 21 (JDK)
sudo apt install openjdk-21-jdk -y

Verify:

java -version
javac -version

# 📦 5. Install Maven
sudo apt install maven -y
mvn -version

# 🔧 6. Install Jenkins
sudo apt install fontconfig openjdk-17-jre -y

Add Jenkins key and repo:

sudo wget -O /usr/share/keyrings/jenkins-keyring.asc \
https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key

echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
/etc/apt/sources.list.d/jenkins.list > /dev/null

Install Jenkins:

sudo apt update
sudo apt install jenkins -y

Start Jenkins:

sudo systemctl start jenkins
sudo systemctl enable jenkins

Check status:

sudo systemctl status jenkins


# 🌐 7. Access Jenkins

Open browser:

http://<EC2-PUBLIC-IP>:8080

# 🔑 8. Unlock Jenkins

Get initial password:

sudo cat /var/lib/jenkins/secrets/initialAdminPassword
Paste password in browser
Install suggested plugins
Create admin user


# 🔗 9. Connect Jenkins to GitHub (Private Repo)
Option 1: Username + Personal Access Token (Recommended)
Go to GitHub → Settings → Developer Settings → Personal Access Token
Generate token (repo access)

In Jenkins:

Manage Jenkins → Credentials → Global → Add Credentials
Kind: Username & Password
Username: GitHub username
Password: Personal Access Token


# 🔄 10. Configure GitHub Webhook

In GitHub repo:

Settings → Webhooks → Add Webhook
Payload URL:
http://<EC2-PUBLIC-IP>:8080/github-webhook/
Content type: application/json
Events: Just push


#⚙️ 11. Create Jenkins Freestyle Project
Go to Jenkins Dashboard
Click "New Item"
Name: jenkins-build
Select: Freestyle Project


#🔧 12. Configure Jenkins Job
Source Code Management:
Select Git
Repository URL:
https://github.com/<your-username>/<repo-name>.git
Credentials: Select saved GitHub credentials
Build Triggers:
Enable:
✅ GitHub hook trigger for GITScm polling
Build Step:
Add → Execute Shell
mvn clean install


# 🚀 13. Run Build
Click "Build Now"
Check "Console Output"
Ensure BUILD SUCCESS


# 📦 14. Run Application
java -jar target/demo-1.0.jar --server.port=9090


# 🌐 15. Access Application
http://<EC2-PUBLIC-IP>:9090



