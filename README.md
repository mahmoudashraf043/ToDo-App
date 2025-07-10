# ✅ To-Do List App (Spring Boot + Docker)

A simple and secure to-do list REST API built with **Spring Boot**, **MySQL**, and **Docker**. It supports user registration and login using **JWT authentication**, task management, and scheduled notifications.

---

## 📦 Features

### 👤 User
- Register new account
- Login with JWT
- Update profile
- Change password
- Delete account
- Get currently logged-in user

### ✅ Task
- Create / update / delete task
- Get task by ID
- Get all tasks
- Get completed tasks
- Get uncompleted tasks

### 🔔 Notifications
- Daily check using `@Scheduled`
- Sends notification if task is due **tomorrow**
- API to get notifications

---

## 🛠 Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Security (JWT)**
- **JPA / Hibernate**
- **MySQL**
- **Docker & Docker Compose**
- **Postman** (for API testing)

---

---

## 🚀 Getting Started

### 1. Clone the Repo

```bash
git clone https://github.com/mahmoud043/ToDo-App.git

docker-compose up --build

```
This runs:

Spring Boot app (backend/)

MySQL database

MySQL will be accessible at:
jdbc:mysql://mysql_db:3306/tododb


📬 Postman Collection
Use the Postman files in the postman/ folder to test all endpoints:

Collection: todo-api.postman_collection.json

Scheduler Feature:
A @Scheduled method runs daily

For each user, if they have a task due tomorrow, a notification is generated and saved

Notifications can be retrieved via /api/notifications

Using Docker and Docker compose to Containerize the App and connect with mysql Container 
## 📦 Docker Image

Pull the pre-built image from Docker Hub:

```bash
docker pull  mahmoudashraf043/to-do-app:1.0
docker run -p 8080:8080  mahmoudashraf043/to-do-app:1.0


