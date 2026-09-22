# ⚡ Smart CRM System

### A production-style, role-based Customer Relationship Management platform built with Spring Boot & React.

<p align="center">

**Secure • Scalable • Role-Based • Cloud Deployed**

</p>

---

## 🌐 Live Application

### 🚀 [Launch Smart CRM](https://smart-crm-tool.netlify.app/)

**Frontend:** `https://smart-crm-tool.netlify.app/`

**Backend API:** `https://smart-crm-backend-8rt4.onrender.com/`

**Database:** MySQL — Aiven Cloud

---

## 📸 What is Smart CRM?

Smart CRM is a full-stack web application designed to centralize customer, lead, task, and user management in one secure platform.

Instead of treating authentication, customer management, leads, and tasks as separate modules, the system connects them through a **role-aware backend architecture**.

```text
                         SMART CRM
                            │
             ┌──────────────┼──────────────┐
             │              │              │
          Customers        Leads          Tasks
             │              │              │
             └──────────────┼──────────────┘
                            │
                    Role-Based Access
                            │
                   ┌────────┴────────┐
                   │                 │
                 USER              ADMIN
```

---

# ✨ Core Features

### 🔐 Secure Authentication

* User registration
* Login authentication
* JWT-based authentication
* BCrypt password hashing
* Stateless authentication
* Protected REST APIs

### 👥 Customer Management

* Create customers
* Update customer information
* View customers
* Search customers
* Filter customers
* Paginated customer data

### 🎯 Lead Management

* Manage sales leads
* Track lead status
* Role-aware lead operations

### ✅ Task Management

* Create and manage tasks
* Assign tasks to users
* Track task status
* Task lifecycle:

```text
PENDING → IN_PROGRESS → COMPLETED
```

### 👑 Administration

* Role-based access control
* USER / ADMIN roles
* Admin-only APIs
* User management
* Admin customer access

---

# 🧠 Architecture

The backend follows a clean layered architecture to keep responsibilities separated and maintainable.

```text
                     React.js Frontend
                            │
                            │ REST / Axios
                            ▼
                 ┌─────────────────────┐
                 │    Spring Boot API  │
                 └──────────┬──────────┘
                            │
                     Spring Security
                            │
                       JWT Filter
                            │
                            ▼
                     ┌────────────┐
                     │ Controller │
                     └─────┬──────┘
                           │
                           ▼
                     ┌──────────┐
                     │ Service  │
                     └────┬─────┘
                          │
                          ▼
                    ┌────────────┐
                    │ Repository │
                    └─────┬──────┘
                          │
                          ▼
                    ┌────────────┐
                    │   MySQL    │
                    └────────────┘
```

### Why this architecture?

Each layer has a clear responsibility:

| Layer      | Responsibility                       |
| ---------- | ------------------------------------ |
| Controller | Handles HTTP requests/responses      |
| Service    | Contains business logic              |
| Repository | Handles database operations          |
| Entity     | Represents database models           |
| Security   | Authentication & authorization       |
| Frontend   | User interface and API communication |

This separation makes the application easier to maintain, test, and extend.

---

# 🔒 Security Architecture

Security is one of the core parts of the application.

```text
User Login
    │
    ▼
Credentials
    │
    ▼
Spring Security
    │
    ├── Verify User
    │
    └── Verify BCrypt Password
    │
    ▼
Generate JWT
    │
    ▼
Frontend
    │
    ▼
Protected API Request
    │
    ▼
JWT Filter
    │
    ▼
Validate Token
    │
    ▼
Identify User + Role
    │
    ▼
Authorization Check
    │
    ▼
Controller
```

### 🔑 Authentication vs Authorization

The application separates these two concepts:

**Authentication**

> "Who are you?"

Handled using login + JWT.

**Authorization**

> "What are you allowed to access?"

Handled using Spring Security roles.

---

# 👑 Role-Based Access Control

The application currently supports:

```text
USER
ADMIN
```

### USER

Regular users can access standard CRM functionality.

### ADMIN

Administrators have additional access to protected administrative operations.

```text
                   AUTHENTICATED USER
                          │
                 ┌────────┴────────┐
                 │                 │
                USER             ADMIN
                 │                 │
          CRM Operations     CRM Operations
                              +
                         Admin Operations
```

New registrations receive the normal `USER` role by default.

This prevents users from simply registering themselves as administrators.

---

# 🔐 Password Protection

Passwords are never intentionally stored as plain text.

The application uses:

```text
BCryptPasswordEncoder
```

Password lifecycle:

```text
Plain Password
      │
      ▼
 BCrypt Hashing
      │
      ▼
Password Hash
      │
      ▼
    MySQL
```

During authentication, the entered password is verified against the stored BCrypt hash.

---

# 📡 REST API Design

The application exposes RESTful endpoints for different CRM modules.

## Authentication

```http
POST /api/auth/register
POST /api/auth/login
PUT  /api/auth/change-password
```

## Customers

```http
POST /api/customers
GET  /api/customers
GET  /api/customers/search
GET  /api/customers/filter
PUT  /api/customers/{id}
```

## Administration

```http
GET /api/admin/users
GET /api/admin/customers
```

The APIs are protected according to authentication and role requirements.

---

# 📄 Pagination

Customer listing supports pagination.

Example:

```http
GET /api/customers?page=0&size=10
```

Instead of retrieving the complete customer table, the API can return a limited page of records.

This helps reduce:

* Response size
* Database load
* Frontend rendering work

---

# 🔎 Search & Filtering

The customer module supports dedicated search and filtering operations.

This allows users to quickly locate relevant CRM records without manually browsing the complete customer list.

---

# 🗃️ Data Model

Core domain entities include:

```text
┌──────────┐
│   User   │
└────┬─────┘
     │
     ├──────────────┐
     │              │
     ▼              ▼
 Customer         Task
     │
     ▼
   Lead
```

### User

Responsible for:

* Authentication
* User identity
* Role
* Access control

### Customer

Stores customer-related information.

### Lead

Represents potential customer/sales information.

### Task

Represents work assigned to users.

Example task states:

```text
PENDING
IN_PROGRESS
COMPLETED
```

---

# ⚙️ Technology Stack

## Backend

| Technology      | Purpose                        |
| --------------- | ------------------------------ |
| Java 21         | Core programming language      |
| Spring Boot     | Backend framework              |
| Spring Security | Authentication & authorization |
| JWT             | Stateless authentication       |
| BCrypt          | Password hashing               |
| Spring Data JPA | Data access                    |
| Hibernate       | ORM                            |
| Maven           | Build & dependency management  |

## Frontend

| Technology   | Purpose           |
| ------------ | ----------------- |
| React.js     | UI                |
| Vite         | Frontend tooling  |
| JavaScript   | Application logic |
| Tailwind CSS | Styling           |
| Axios        | API communication |

## Infrastructure

| Technology | Purpose                        |
| ---------- | ------------------------------ |
| MySQL      | Relational database            |
| Aiven      | Cloud database hosting         |
| Render     | Backend deployment             |
| Netlify    | Frontend deployment            |
| Docker     | Backend containerization       |
| GitHub     | Source control & CI/CD trigger |

---

# 🔄 Production Deployment

The application is deployed using a cloud-based architecture.

```text
                 GitHub
                   │
          ┌────────┴────────┐
          │                 │
          ▼                 ▼
       Netlify            Render
          │                 │
          ▼                 ▼
      React.js          Spring Boot
                            │
                            │
                            ▼
                       Aiven MySQL
```

### Frontend

Hosted on **Netlify**

```text
https://smart-crm-tool.netlify.app/
```

### Backend

Hosted on **Render**

```text
https://smart-crm-backend-8rt4.onrender.com/
```

### Database

Hosted on **Aiven Cloud**

---

# 🐳 Dockerized Backend

The Spring Boot backend includes a `Dockerfile`.

Render builds the application from the repository and uses the Docker configuration during deployment.

```text
Git Push
   │
   ▼
GitHub
   │
   ▼
Render
   │
   ▼
Docker Build
   │
   ▼
Spring Boot Container
   │
   ▼
Production API
```

---

# 🔁 Automatic Deployment

The backend repository is connected directly to Render.

Whenever updated backend code is pushed to GitHub:

```text
Code Change
     ↓
git push
     ↓
GitHub
     ↓
Render detects change
     ↓
Docker build
     ↓
Application deployment
     ↓
Updated API
```

This removes the need to manually create and deploy a Docker image for every backend change.

---

# 🌍 Environment Configuration

Production configuration uses environment variables rather than hardcoding sensitive credentials.

### Backend

```text
DB_URL
DB_USERNAME
DB_PASSWORD
FRONTEND_URL
```

### Frontend

```text
VITE_API_URL
```

Production frontend communicates with:

```text
https://smart-crm-backend-8rt4.onrender.com/api
```

Sensitive credentials are intentionally excluded from source control.

---

# 🌐 CORS & Frontend Communication

The React frontend communicates with the Spring Boot backend using Axios.

```text
React
  │
  │ Axios
  ▼
Spring Boot API
  │
  │ CORS validation
  ▼
Spring Security
  │
  ▼
Application
```

The production frontend origin is configured through environment-based configuration.

---

# 🧪 API Testing

The REST APIs can be tested using Postman.

Typical protected request:

```http
Authorization: Bearer <JWT_TOKEN>
```

Example flow:

```text
Register
   ↓
Login
   ↓
Receive JWT
   ↓
Attach JWT
   ↓
Access Protected API
```

---

# 📁 Project Structure

```text
smart-crm-system/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/crm/backend/
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── Dockerfile
├── pom.xml
├── .gitignore
└── README.md
```

---

# ⚡ API Request Lifecycle

A typical authenticated request flows through the application like this:

```text
React UI
   ↓
Axios
   ↓
Authorization: Bearer JWT
   ↓
JWT Filter
   ↓
Token Validation
   ↓
Spring Security
   ↓
Role Check
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
Hibernate / JPA
   ↓
MySQL
   ↓
Response
   ↓
React UI
```

---

# 📈 Performance & Scalability Considerations

The application already uses patterns that make future scaling easier:

* Layered backend architecture
* Pagination
* Database-backed persistence
* Stateless JWT authentication
* REST API architecture
* Environment-based configuration
* Dockerized backend

Potential future additions can include caching, asynchronous processing, monitoring, and distributed services as the system grows.

---

# 🚀 Future Roadmap

The architecture can be extended with features such as:

* 🔔 Follow-up reminders
* 📧 Automated email notifications
* 📊 Advanced CRM analytics
* 🕒 Activity timeline
* 📁 Document management
* ⚡ Redis caching
* 📨 Kafka-based event processing
* ☁️ Advanced cloud infrastructure
* 📈 Monitoring & observability
* 🔐 More granular permissions

---

# 💡 Why Smart CRM?

The project combines several real-world backend concepts into one application:

```text
Authentication
      +
Authorization
      +
REST APIs
      +
Database Management
      +
Frontend Integration
      +
Cloud Deployment
      +
Docker
      +
CI/CD
```

The result is a complete full-stack system rather than an isolated CRUD application.

---

# 👩‍💻 Built By

## Sonali Kumari Shahi

**Java | Spring Boot | React.js | MySQL**

GitHub: `Sonalishahi06`

---

## ⭐ Project Snapshot

```text
┌─────────────────────────────────────────────┐
│              SMART CRM SYSTEM               │
├─────────────────────────────────────────────┤
│                                             │
│  ⚡ Spring Boot Backend                     │
│  ⚛️ React Frontend                          │
│  🔐 JWT Authentication                      │
│  🛡️ Role-Based Authorization                │
│  🔑 BCrypt Password Hashing                 │
│  👥 Customer Management                     │
│  🎯 Lead Management                         │
│  ✅ Task Management                         │
│  🔎 Search & Filtering                      │
│  📄 Pagination                              │
│  🗄️ MySQL + Aiven                           │
│  🐳 Docker                                  │
│  ☁️ Render + Netlify                        │
│  🔄 GitHub Automatic Deployment             │
│                                             │
└─────────────────────────────────────────────┘
```

### 🔗 Live Demo

**https://smart-crm-tool.netlify.app/**





