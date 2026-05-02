# 🚀 CI/CD Setup using AWS EC2, Jenkins & Spring Boot

This project demonstrates a complete step-by-step CI/CD setup using AWS EC2, Jenkins, Maven, and a Spring Boot application.

---

## 📌 Step 1: Launch AWS EC2 Instance

- Go to AWS Console → EC2 → Launch Instance  
- Select Ubuntu (22.04 LTS)  
- Choose instance type: t2.micro  
- Create/select key pair  
- Configure Security Group:
  - Port 22 (SSH)
  - Port 8080 (Jenkins)
  - Port 9090 (Application)
- Launch instance  

### 📸 Screenshot
<img width="1917" height="922" alt="EC2 instance" src="https://github.com/user-attachments/assets/05fe8cb6-dea4-41cc-931d-47eeb60adb18" />
<img width="1907" height="905" alt="SG" src="https://github.com/user-attachments/assets/fa537e5e-0847-428e-b7ff-35b6edf70ceb" />


---

## 🔑 Step 2: Connect to EC2 via SSH

```bash
chmod 400 your-key.pem
ssh -i your-key.pem ubuntu@<EC2-PUBLIC-IP>


### 📸 Screenshot
![SSH](images/ssh-connection.png)

---

## ⚙️ Step 3: Update System

```bash
sudo apt update && sudo apt upgrade -y
```
<img width="1468" height="751" alt="SSH-1" src="https://github.com/user-attachments/assets/d1383bdb-4984-473f-a651-b997551e1556" />
<img width="1471" height="747" alt="SSH-2" src="https://github.com/user-attachments/assets/f34ad691-dfcc-4e53-a601-a4cec4839678" />

---

## ☕ Step 4: Install Java 21

```bash
sudo apt install openjdk-21-jdk -y
```

Verify:

```bash
java -version
javac -version
```

---

## 📦 Step 5: Install Maven

```bash
sudo apt install maven -y
```

Verify:

```bash
mvn -version
```

### 📸 Screenshot
<img width="1468" height="750" alt="applications install" src="https://github.com/user-attachments/assets/4aa2ba11-2edf-4503-97ba-a369316c6742" />

---

## 🔧 Step 6: Install Jenkins

```bash
sudo apt install fontconfig openjdk-17-jre -y
```

```bash
sudo wget -O /usr/share/keyrings/jenkins-keyring.asc \
https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key
```

```bash
echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
/etc/apt/sources.list.d/jenkins.list > /dev/null
```

```bash
sudo apt update
sudo apt install jenkins -y
```

Start Jenkins:

```bash
sudo systemctl start jenkins
sudo systemctl enable jenkins
```

Check status:

```bash
sudo systemctl status jenkins
```

---

## 🌐 Step 7: Access Jenkins

Open in browser:

http://<EC2-PUBLIC-IP>:8080

---

## 🔑 Step 8: Unlock Jenkins

```bash
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
```

- Paste password in browser  
- Install suggested plugins  
- Create admin user  

### 📸 Screenshot
<img width="1917" height="966" alt="Jenkins page" src="https://github.com/user-attachments/assets/f09db197-bb90-4ff8-8353-e2967dfe0529" />


---

## 🔗 Step 9: Connect Jenkins to GitHub (Private Repo)

- Generate Personal Access Token in GitHub  
- In Jenkins → Manage Jenkins → Credentials → Add:
  - Username
  - Token  

### 📸 Screenshot
<img width="1917" height="896" alt="code Files" src="https://github.com/user-attachments/assets/28725e02-80bf-40a1-96b9-4d870cffb30e" />
<img width="1908" height="906" alt="git integration" src="https://github.com/user-attachments/assets/3c2a8495-a979-435a-b52f-db7ce53f7bbb" />


---

## 🔄 Step 10: Configure GitHub Webhook

Add webhook:

http://<EC2-PUBLIC-IP>:8080/github-webhook/

- Content type: application/json  
- Event: Just push  

### 📸 Screenshot
<img width="1917" height="901" alt="Webhook integration" src="https://github.com/user-attachments/assets/f7956326-1f32-46da-af1e-6dd9a7d4d016" />


---

## ⚙️ Step 11: Create Jenkins Freestyle Project

- Jenkins Dashboard → New Item  
- Name: jenkins-build  
- Select Freestyle Project  

### 📸 Screenshot
<img width="1907" height="902" alt="Jenkins Dashboard" src="https://github.com/user-attachments/assets/a5f2099e-8bb3-4954-b6bc-466457b51932" />


---

## 🔧 Step 12: Configure Jenkins Job

**Source Code Management**
- Select Git  
- Add repository URL  
- Select credentials  

**Build Trigger**
- Enable GitHub hook trigger  

**Build Step**

```bash
mvn clean install
```

### 📸 Screenshot
<img width="1907" height="900" alt="Jenkins Git Integration" src="https://github.com/user-attachments/assets/fd6676fb-9037-4c89-afae-816eec4aa77c" />
<img width="1911" height="901" alt="Shell Execution" src="https://github.com/user-attachments/assets/c9ee2e27-5384-469f-b28b-6c61d2f226cb" />

---

## 🚀 Step 13: Run Build

- Click Build Now  
- Check Console Output  
- Ensure BUILD SUCCESS  

### 📸 Screenshot
<img width="1896" height="905" alt="Automated Builds" src="https://github.com/user-attachments/assets/0b9ec555-40a5-4580-991b-635476432b79" />


---

## 📦 Step 14: Run Application

```bash
java -jar target/demo-1.0.jar --server.port=9090
```

### 📸 Screenshot
<img width="1896" height="905" alt="Automated Builds" src="https://github.com/user-attachments/assets/836ab294-8067-403f-b38c-a18bdbb3a6e5" />


---

## 🌐 Step 15: Access Application

http://<EC2-PUBLIC-IP>:9090

### 📸 Screenshot
<img width="1468" height="750" alt="applications install" src="https://github.com/user-attachments/assets/95a4f685-8980-4ff0-9fce-cfde0a7788dd" />

---

## ⚠️ Challenges Faced

- Java/JDK mismatch  
- Maven build errors  
- Port conflicts  
- Jenkins configuration issues  
- AWS Security Group setup  

---

## 📚 Key Learnings

- CI/CD basics using Jenkins  
- GitHub integration  
- AWS EC2 deployment  
- Debugging real-world issues  

---

## 🔮 Future Improvements

- Jenkins Pipeline (Jenkinsfile)  
- Automated testing  
- Docker integration  

---

## 📝 Note

This setup was created on a temporary AWS EC2 instance for learning purposes.
