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

<img width="1468" height="751" alt="SSH-1" src="https://github.com/user-attachments/assets/9705de03-b150-40e6-8ba5-8f4ea97d42c6" />
<img width="1471" height="747" alt="SSH-2" src="https://github.com/user-attachments/assets/c6b5d5fa-9d03-4b48-a7fa-8d2047417a9c" />



