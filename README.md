🚀 Smart CRM System

A secure Customer Relationship Management (CRM) backend application built using Spring Boot, Spring Security, JWT Authentication, Role-Based Authorization, and MySQL.

📌 Project Overview

Smart CRM System helps businesses manage customer data securely through RESTful APIs. The project follows a layered architecture and implements authentication, authorization, and user-specific data access similar to real-world CRM applications.

🛠️ Tech Stack

Backend

* Java 21
* Spring Boot
* Spring Security
* JWT Authentication
* Spring Data JPA
* Hibernate
* Maven

Database

* MySQL

Tools

* Git & GitHub
* Postman
* IntelliJ IDEA

✨ Features

🔐 Authentication & Security

* User Registration
* User Login
* BCrypt Password Encryption
* JWT Token Generation
* JWT-Based Authentication
* Protected API Endpoints

👥 Customer Management

* Create Customer
* View Customer Details
* Update Customer Information
* Delete Customer

🛡️ Authorization & Access Control

* Role-Based Authorization (ADMIN / USER)
* Admin Protected Endpoints
* User-Specific Customer Access
* Admin Can View All Customers
* 403 Forbidden for Unauthorized Access

🏗️ Backend Architecture

* RESTful APIs
* DTO-Based Design
* Layered Architecture

  * Controller
  * Service
  * Repository
* Clean Code Structure

📂 Project Structure

src
├── controller
├── service
├── repository
├── dto
├── entity
├── config
├── security

▶️ How to Run

1. Clone Repository

git clone <repository-url>

2. Configure MySQL

Update application.properties with your database credentials.

3. Run Application

mvn spring-boot:run

4. Test APIs

Use Postman to test Authentication, Authorization, and Customer APIs.

🚀 Future Enhancements

* Global Exception Handling
* Request Validation
* Swagger/OpenAPI Documentation
* React.js Frontend
* Customer Dashboard
* Docker Deployment
* AWS Deployment

👩‍💻 Author

Sonali Kumari Shahi

Java Full-Stack Developer | Spring Boot | Spring Security | JWT | MySQL | REST APIs




