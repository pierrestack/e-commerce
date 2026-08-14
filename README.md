# 🛒 E-Commerce API

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0-green?style=for-the-badge&logo=springboot)
![Spring Security](https://img.shields.io/badge/Spring_Security-JWT-success?style=for-the-badge&logo=springsecurity)
![MySQL](https://img.shields.io/badge/MySQL-8-blue?style=for-the-badge&logo=mysql)
![Docker](https://img.shields.io/badge/Docker-Containerized-2496ED?style=for-the-badge&logo=docker)
![phpMyAdmin](https://img.shields.io/badge/phpMyAdmin-Database_UI-6C78AF?style=for-the-badge&logo=phpmyadmin)

A modern RESTful E-Commerce API built with Spring Boot, featuring JWT authentication, Docker support, MySQL integration, exception handling, and layered architecture.

**Project Status:** 🚧 Under Active Development

---

# 🚀 Features

- ✅ JWT Authentication
- ✅ Access Token & Refresh Token
- ✅ User CRUD
- ✅ Product CRUD
- ✅ Category CRUD
- ✅ BCrypt Password Encryption
- ✅ Global Exception Handling
- ✅ DTO Pattern
- ✅ Layered Architecture
- ✅ Dockerized Environment
- ✅ MySQL Database Integration
- ✅ phpMyAdmin Integration
- ✅ Default Admin Seeder
- ✅ Environment Variables Configuration

---

# 🏗️ Tech Stack

| Technology | Version |
|---|---|
| Java | 21 |
| Spring Boot | 4 |
| Spring Security | Latest |
| Spring Data JPA | Latest |
| MySQL | 8 |
| Docker | Latest |
| phpMyAdmin | Latest |
| JWT (JJWT) | Latest |
| Maven | Latest |

---
# 📁 Project Structure

```bash
src/main/java/com/ecommerce
│
├── config/
├── controllers/
├── dto/
├── enums/
├── entities/
├── exceptions/
├── repositories/
├── services/
├── security/
└── EcommerceApiApplication.java
````
---

# ⚙️ Environment Variables

Create a `.env` file at the root of the project.

## Example

```env
# ===============================
# MYSQL
# ===============================

MYSQL_ROOT_PASSWORD=root
MYSQL_DATABASE=ecommerce_db

# ===============================
# SPRING DATASOURCE
# ===============================

SPRING_DATASOURCE_URL=jdbc:mysql://db:3306/ecommerce_db
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=root

# ===============================
# JWT
# ===============================

JWT_SECRET_KEY=your-super-secret-key-your-super-secret-key

JWT_ACCESS_EXPIRATION=900000
JWT_REFRESH_EXPIRATION=604800000

# ===============================
# DEFAULT ADMIN
# ===============================

ADMIN_USERNAME=admin
ADMIN_EMAIL=admin@example.com
ADMIN_PASSWORD=admin123
```

---

# 🔐 Security

This API uses JWT Authentication with:

* Access Token
* Refresh Token
* BCrypt Password Encoding
* Stateless Authentication
* Custom JWT Filter

---

# 👤 Default Admin

A default admin account is automatically created when the application starts.

| Field    | Value                                         |
| -------- | --------------------------------------------- |
| Username | admin                                         |
| Email    | [admin@example.com](mailto:admin@example.com) |
| Password | admin123                                      |

⚠️ Change these credentials in production.

---

# 🐳 Docker Setup

## Start containers

```bash
docker compose up --build
```

---

## Stop containers

```bash
docker compose down
```

---

## Rebuild without cache

```bash
docker compose build --no-cache
```

---

## Remove containers and volumes

```bash
docker compose down -v
```

---

# 🌐 Services

| Service    | URL                   |
| ---------- | --------------------- |
| API        | http://localhost:8080 |
| phpMyAdmin | http://localhost:8081 |

---

# 🗄️ Database Access

| Field    | Value        |
| -------- | ------------ |
| Host     | db           |
| Port     | 3306         |
| Database | ecommerce_db |
| Username | root         |
| Password | root         |

---

# 🔑 Authentication Endpoints

## Login

```http
POST /api/auth/login
```

### Request Body

```json
{
  "email": "admin@example.com",
  "password": "admin123"
}
```
---

## Refresh Token

```http
POST /api/auth/refresh
```

---

# 📦 API Endpoints

## Users

| Method | Endpoint          |
| ------ | ----------------- |
| GET    | `/api/users`      |
| GET    | `/api/users/{id}` |
| POST   | `/api/users`      |
| PUT    | `/api/users/{id}` |
| DELETE | `/api/users/{id}` |

---

## Products

| Method | Endpoint             |
| ------ | -------------------- |
| GET    | `/api/products`      |
| GET    | `/api/products/{id}` |
| POST   | `/api/products`      |
| PUT    | `/api/products/{id}` |
| DELETE | `/api/products/{id}` |

---

## Categories

| Method | Endpoint               |
| ------ | ---------------------- |
| GET    | `/api/categories`      |
| GET    | `/api/categories/{id}` |
| POST   | `/api/categories`      |
| PUT    | `/api/categories/{id}` |
| DELETE | `/api/categories/{id}` |

---

# ⚠️ Exception Handling

The API provides centralized exception handling.

## Example Response

```json
{
  "timestamp": "2026-05-10T10:20:00",
  "status": 404,
  "error": "NOT_FOUND",
  "message": "Product not found",
  "path": "/api/products/1"
}
```
---

# 🧪 Run Locally Without Docker

## Windows

```bash
.\mvnw.cmd spring-boot:run
```

---

## Linux / Mac

```bash
./mvnw spring-boot:run
```

---

# 📌 Future Improvements

* Swagger / OpenAPI Documentation
* Pagination & Sorting
* Product Image Upload
* Order Management
* Payment Integration
* Unit & Integration Tests
* CI/CD Pipeline
* Redis Caching

---

# 👨‍💻 Author

Developed with ❤️ using Spring Boot and Docker.

```
```
