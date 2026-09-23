# ⚡ Smart CRM System

> A production-style, role-based Customer Relationship Management platform built with **Spring Boot & React.js**.

Smart CRM is a full-stack CRM application designed to manage **customers, leads, tasks, users and dashboard analytics** with secure JWT authentication and role-based access control.

It demonstrates a production-oriented architecture using **Java 21, Spring Boot, Spring Security, JWT, React.js, MySQL and REST APIs**.

---

## 🚀 Live Application

🌐 **Frontend:**
https://smart-crm-tool.netlify.app/

⚙️ **Backend API:**
https://smart-crm-backend-8rt4.onrender.com/

💻 **GitHub Repository:**
https://github.com/Sonalishahi06/smart-crm-system

---

# 📌 What is Smart CRM?

Smart CRM is a full-stack Customer Relationship Management system that allows users to:

* Register and securely log in
* Manage customer information
* Search and filter customers
* Manage leads
* Create and track tasks
* View dashboard statistics
* Access features based on user roles
* Manage users and customers as an administrator

The application follows a **REST-based backend architecture** with a React frontend communicating through secured APIs.

---

# 🏗️ System Architecture

```text
                    ┌──────────────────────┐
                    │      React.js        │
                    │   Frontend / UI      │
                    └──────────┬───────────┘
                               │
                         REST API / JSON
                               │
                               ▼
                    ┌──────────────────────┐
                    │    Spring Boot       │
                    │      Backend         │
                    ├──────────────────────┤
                    │ Controllers          │
                    │ Services             │
                    │ Repositories         │
                    │ Spring Security      │
                    │ JWT Authentication   │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │       MySQL          │
                    │      Database        │
                    └──────────────────────┘
```

---

# ✨ Core Features

## 🔐 Secure Authentication

* User registration
* User login
* JWT-based authentication
* BCrypt password hashing
* Stateless authentication
* Protected REST APIs
* Change password API
* Automatic token validation

## 👥 Customer Management

* Create customers
* View customers
* Update customers
* Delete customers
* Pagination
* Search customers by name
* Filter customers by status
* User-based customer ownership

## 🎯 Lead Management

* Create leads
* View leads
* Update lead status
* Lead lifecycle tracking

Supported lead statuses:

```text
NEW
QUALIFIED
CONTACTED
WON
LOST
```

## 📋 Task Management

* Create tasks
* View tasks
* Update task status
* Assign tasks to users
* Track task progress

Supported task statuses:

```text
PENDING
IN_PROGRESS
COMPLETED
```

## 📊 Dashboard

The dashboard provides real-time information such as:

* Total customers
* Total leads
* Total tasks
* Lead status distribution
* Task status distribution

## 👑 Administration

Administrators can:

* View registered users
* View customers
* Access admin-only APIs

---

# 🔒 Security Architecture

Smart CRM uses **Spring Security + JWT** for authentication and authorization.

### Authentication Flow

```text
User
  │
  ▼
Login
  │
  ▼
Spring Boot
  │
  ├── Verify email
  ├── Verify BCrypt password
  │
  ▼
Generate JWT
  │
  ▼
Return JWT to Frontend
  │
  ▼
Frontend stores token
  │
  ▼
JWT sent with protected requests
```

Protected requests use:

```http
Authorization: Bearer <JWT_TOKEN>
```

---

# 🛡️ Role-Based Access Control

The application supports two roles:

| Role  | Access                                 |
| ----- | -------------------------------------- |
| USER  | Customers, Leads, Tasks, Dashboard     |
| ADMIN | USER permissions + Administration APIs |

Spring Security checks the user's role before allowing access to protected endpoints.

Example:

```text
/api/admin/**
```

is restricted to:

```text
ROLE_ADMIN
```

---

# 🔑 Password Protection

Passwords are never stored as plain text.

The application uses:

```text
BCryptPasswordEncoder
```

for secure password hashing.

Authentication is stateless using JWT tokens.

---

# 🌐 REST API Design

Smart CRM provides **22 REST API endpoints**.

## 🔐 Authentication APIs

| Method | Endpoint                    | Description       | Access        |
| ------ | --------------------------- | ----------------- | ------------- |
| POST   | `/api/auth/register`        | Register new user | Public        |
| POST   | `/api/auth/login`           | Login user        | Public        |
| PUT    | `/api/auth/change-password` | Change password   | Authenticated |

---

## 👥 Customer APIs

| Method | Endpoint                | Description                   | Access       |
| ------ | ----------------------- | ----------------------------- | ------------ |
| POST   | `/api/customers`        | Create customer               | USER / ADMIN |
| GET    | `/api/customers`        | Get customers with pagination | USER / ADMIN |
| GET    | `/api/customers/search` | Search customers by name      | USER / ADMIN |
| GET    | `/api/customers/filter` | Filter customers by status    | USER / ADMIN |
| PUT    | `/api/customers/{id}`   | Update customer               | USER / ADMIN |
| DELETE | `/api/customers/{id}`   | Delete customer               | USER / ADMIN |

---

## 📊 Dashboard APIs

| Method | Endpoint                         | Description                | Access       |
| ------ | -------------------------------- | -------------------------- | ------------ |
| GET    | `/api/dashboard/customers/count` | Get total customer count   | USER / ADMIN |
| GET    | `/api/dashboard/leads/count`     | Get total lead count       | USER / ADMIN |
| GET    | `/api/dashboard/tasks/count`     | Get total task count       | USER / ADMIN |
| GET    | `/api/dashboard/leads/status`    | Get lead status statistics | USER / ADMIN |
| GET    | `/api/dashboard/tasks/status`    | Get task status statistics | USER / ADMIN |

---

## 🎯 Lead APIs

| Method | Endpoint                 | Description        | Access       |
| ------ | ------------------------ | ------------------ | ------------ |
| POST   | `/api/leads`             | Create lead        | USER / ADMIN |
| GET    | `/api/leads`             | Get leads          | USER / ADMIN |
| PUT    | `/api/leads/{id}/status` | Update lead status | USER / ADMIN |

---

## 📋 Task APIs

| Method | Endpoint                 | Description        | Access       |
| ------ | ------------------------ | ------------------ | ------------ |
| POST   | `/api/tasks`             | Create task        | USER / ADMIN |
| GET    | `/api/tasks`             | Get tasks          | USER / ADMIN |
| PUT    | `/api/tasks/{id}/status` | Update task status | USER / ADMIN |

---

## 👑 Administration APIs

| Method | Endpoint               | Description       | Access |
| ------ | ---------------------- | ----------------- | ------ |
| GET    | `/api/admin/users`     | Get all users     | ADMIN  |
| GET    | `/api/admin/customers` | Get all customers | ADMIN  |

---

# 📌 API Summary

```text
Authentication     → 3 APIs
Customers          → 6 APIs
Dashboard          → 5 APIs
Leads              → 3 APIs
Tasks              → 3 APIs
Administration     → 2 APIs
--------------------------------
Total              → 22 APIs
```

---

# 📄 Pagination

Customer listing supports pagination.

Example:

```http
GET /api/customers?page=0&size=10
```

This helps avoid loading a large number of records at once and improves API performance.

---

# 🔎 Search & Filtering

### Search

Customers can be searched by name:

```http
GET /api/customers/search?name=Rahul
```

### Filter

Customers can be filtered by status:

```http
GET /api/customers/filter?status=ACTIVE
```

---

# 🗃️ Data Model

Main entities used in the application:

```text
User
 │
 ├── Customer
 │
 ├── Lead
 │
 └── Task
```

### User

Stores authentication and authorization information.

Example fields:

```text
id
name
email
password
role
```

### Customer

Stores customer-related information.

### Lead

Stores sales lead information and lead status.

### Task

Stores task information including:

```text
id
title
description
assignedTo
status
createdAt
```

---

# 🛠️ Technology Stack

## Backend

* Java 21
* Spring Boot 3.5.0
* Spring Security
* JWT
* BCrypt
* Spring Data JPA
* Hibernate
* REST APIs
* Maven

## Frontend

* React.js
* Vite
* JavaScript
* Tailwind CSS
* Axios

## Database

* MySQL

## Development Tools

* IntelliJ IDEA
* VS Code
* Postman
* Git
* GitHub

## Deployment

* Netlify
* Render
* Aiven MySQL

---

# 🏛️ Backend Architecture

The backend follows a layered architecture:

```text
Controller
     │
     ▼
Service
     │
     ▼
Repository
     │
     ▼
Database
```

### Controller Layer

Handles:

* HTTP requests
* Request validation
* API endpoints
* HTTP responses

### Service Layer

Contains:

* Business logic
* Authentication logic
* Customer management
* Lead management
* Task management

### Repository Layer

Handles database operations using Spring Data JPA.

### Security Layer

Handles:

* JWT authentication
* User authorization
* Password encryption
* Role-based access

---

# 📁 Project Structure

```text
smart-crm-system/
│
├── backend/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/
│   │       │       └── crm/
│   │       │           └── backend/
│   │       │               ├── config/
│   │       │               ├── controller/
│   │       │               ├── dto/
│   │       │               ├── entity/
│   │       │               ├── repository/
│   │       │               ├── security/
│   │       │               └── service/
│   │       │
│   │       └── resources/
│   │           └── application.properties
│   │
│   └── pom.xml
│
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── services/
│   │   └── App.jsx
│   │
│   ├── public/
│   │   └── _redirects
│   │
│   └── package.json
│
└── README.md
```

---

# 🔄 API Request Lifecycle

Example: Customer creation

```text
React Frontend
      │
      ▼
Axios Request
      │
      ▼
JWT Token
      │
      ▼
Spring Security
      │
      ▼
JWT Validation
      │
      ▼
Controller
      │
      ▼
Service
      │
      ▼
Repository
      │
      ▼
MySQL
      │
      ▼
Response
      │
      ▼
React UI
```

---

# 🌍 Production Deployment

The application is deployed using separate frontend, backend and database services.

```text
React + Vite
     │
     ▼
Netlify
     │
     │ HTTPS
     ▼
Render
     │
     ▼
Spring Boot
     │
     │ SSL
     ▼
Aiven MySQL
```

### Frontend

Hosted on:

```text
Netlify
```

### Backend

Hosted on:

```text
Render
```

### Database

Hosted on:

```text
Aiven MySQL
```

---

# ⚙️ Environment Configuration

Sensitive configuration values are stored using environment variables.

Example:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

frontend.url=${FRONTEND_URL}
```

Frontend:

```text
VITE_API_URL
```

Sensitive credentials are not committed to GitHub.

---

# 🌐 CORS & Frontend Communication

The backend is configured to allow communication between the local development environment and the deployed frontend.

Development:

```text
http://localhost:5173
```

Production:

```text
https://smart-crm-tool.netlify.app
```

Axios is used for API communication.

JWT is automatically attached to protected API requests using an Axios interceptor.

---

# 🧪 API Testing

APIs were tested using **Postman**.

Testing includes:

* User registration
* User login
* JWT authentication
* Customer CRUD
* Customer search
* Customer filtering
* Pagination
* Lead operations
* Task operations
* Dashboard APIs
* Admin APIs
* Unauthorized requests
* Role-based access

---

# 🚀 Running the Project Locally

## 1. Clone Repository

```bash
git clone https://github.com/Sonalishahi06/smart-crm-system.git
```

```bash
cd smart-crm-system
```

---

## 2. Backend Setup

Go to backend:

```bash
cd backend
```

Configure database environment variables:

```text
DB_URL
DB_USERNAME
DB_PASSWORD
FRONTEND_URL
```

Then run:

```bash
mvn spring-boot:run
```

Backend will run on:

```text
http://localhost:8080
```

---

## 3. Frontend Setup

Go to frontend:

```bash
cd frontend
```

Install dependencies:

```bash
npm install
```

Create environment variable:

```text
VITE_API_URL=http://localhost:8080/api
```

Run:

```bash
npm run dev
```

Frontend will run on:

```text
http://localhost:5173
```

---

# 🐳 Dockerized Backend

The backend can be packaged and deployed using Docker.

Example:

```bash
docker build -t smart-crm-backend .
```

Run:

```bash
docker run -p 8080:8080 smart-crm-backend
```

Docker helps provide a consistent runtime environment for deployment.

---

# 🔄 Automatic Deployment

The project is connected with GitHub-based deployment workflows.

When changes are pushed to the configured repository:

```text
GitHub
   │
   ├── Backend → Render
   │
   └── Frontend → Netlify
```

This allows updated versions of the application to be deployed automatically.

---

# 📈 Performance & Scalability

The application includes several design choices for scalability:

* Pagination for customer records
* Database indexing can be added for frequently searched fields
* Stateless JWT authentication
* Layered backend architecture
* RESTful API design
* Separate frontend and backend deployment
* Externalized environment configuration

The architecture can be extended with:

```text
Redis
Docker
Kafka
Microservices
Cloud infrastructure
```

as the system grows.

---

# 🔮 Future Roadmap

Planned improvements include:

* Follow-up reminder system
* Email notifications
* Advanced CRM analytics
* Customer activity timeline
* File/document management
* Redis caching
* Docker Compose
* Kafka-based event processing
* Microservices architecture
* Cloud deployment improvements

---

# 💡 Why Smart CRM?

This project demonstrates practical experience with:

* Java backend development
* Spring Boot
* Spring Security
* JWT authentication
* BCrypt password hashing
* Role-based authorization
* REST API development
* React.js
* MySQL
* JPA/Hibernate
* API integration
* Pagination
* Search and filtering
* Postman API testing
* Git/GitHub
* Production deployment

---

# 📊 Project Snapshot

| Category          | Details                   |
| ----------------- | ------------------------- |
| Application       | Smart CRM System          |
| Architecture      | Full Stack                |
| Backend           | Spring Boot               |
| Frontend          | React.js + Vite           |
| Language          | Java 21                   |
| Database          | MySQL                     |
| Authentication    | JWT                       |
| Password Security | BCrypt                    |
| Authorization     | Role-Based Access Control |
| REST APIs         | 22                        |
| Frontend Hosting  | Netlify                   |
| Backend Hosting   | Render                    |
| Database Hosting  | Aiven                     |
| API Testing       | Postman                   |
| Source Control    | Git + GitHub              |

---

# 👩‍💻 Built By

**Sonali Kumari Shahi**

B.Tech — Electrical & Electronics Engineering

Interested in:

* Java Development
* Spring Boot
* Backend Development
* Full-Stack Development
* REST APIs
* Software Engineering

---
# 🔗 Project Links

🌐 **Live Application**
https://smart-crm-tool.netlify.app/

💻 **Backend Repository**
https://github.com/Sonalishahi06/smart-crm-system

🎨 **Frontend Repository**
https://github.com/Sonalishahi06/CRM-frontend

⚙️ **Backend API**
https://smart-crm-backend-8rt4.onrender.com/

---

# ⭐ Project

If you find this project useful, feel free to explore the repository and provide feedback.






