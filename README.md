# 🚀 Smart CRM System

A secure and scalable Customer Relationship Management (CRM) backend application built with Spring Boot, Spring Security, JWT Authentication, Role-Based Authorization, and MySQL.

## 📖 Overview

Smart CRM System is a backend application designed to help businesses securely manage customer information through RESTful APIs.

The project implements modern backend development practices including authentication, authorization, request validation, exception handling, and user-specific data access.

It follows a clean layered architecture and simulates real-world CRM functionality where different users have different access levels.

---

## ✨ Key Features

### 🔐 Authentication & Security

* User Registration
* User Login
* BCrypt Password Encryption
* JWT Token Generation
* JWT-Based Authentication
* Protected REST APIs

### 🛡️ Authorization & Access Control

* Role-Based Authorization (ADMIN / USER)
* Admin Protected Endpoints
* User-Specific Customer Access
* Admin Access to All Customers
* 403 Forbidden for Unauthorized Requests

### 👥 Customer Management

* Create Customer
* View Customer Details
* Update Customer Information
* Delete Customer
* Customer Ownership Tracking

### ✅ Validation & Error Handling

* Request Validation
* Global Exception Handling
* Custom Exception Handling
* Duplicate Email Prevention
* Meaningful HTTP Status Codes

---

## 🛠️ Tech Stack

### Backend

* Java 21
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA
* Hibernate
* Maven

### Database

* MySQL

### Tools & Platforms

* Git & GitHub
* Postman
* IntelliJ IDEA

---

## 🏗️ Architecture

The project follows a layered architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

### Project Structure

```text
src/main/java
│
├── controller
├── service
├── repository
├── dto
├── entity
├── config
├── exception
└── security
```

---

## 🔄 API Workflow

### Authentication Flow

```text
Register User
      ↓
Login User
      ↓
Generate JWT Token
      ↓
Access Protected APIs
```

### Authorization Flow

```text
USER
 └── Manage Own Customers

ADMIN
 ├── Manage Own Customers
 ├── View All Customers
 └── Access Admin APIs
```

---

## ▶️ Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Sonalishahi06/smart-crm-system.git
cd smart-crm-system
```

### 2. Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/crm_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

### 4. Test APIs

Use Postman to test:

* Authentication APIs
* Customer APIs
* Admin APIs
* Authorization Rules

---

## 🚀 Upcoming Enhancements

* Pagination
* Search & Filter APIs
* Swagger / OpenAPI Documentation
* React Frontend
* Customer Analytics Dashboard
* Docker Containerization
* AWS Deployment

---


Focused on:

* Spring Boot
* Spring Security
* REST APIs
* JWT Authentication
* Database Design
* Backend System Development

GitHub:
https://github.com/Sonalishahi06

---

⭐ If you found this project useful, consider giving it a star.




