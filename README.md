# Job App Backend

A Spring Boot REST API application for job listings and user management with role-based access control.

## Technologies and Concepts

- **Java**: Core programming language
- **Spring Boot**: Framework for building production-ready applications
- **Spring Security**: Authentication and authorization with role-based access control
- **JWT (JSON Web Tokens)**: Stateless authentication mechanism
- **Spring Data JPA**: Data persistence layer
- **REST API**: RESTful endpoints for client-server communication
- **Enum Persistence**: Using `@Enumerated(EnumType.STRING)` for readable database values
- **Lombok**: Reducing boilerplate code
- **Dependency Injection**: Constructor-based injection for loose coupling
- **Request/Response Pattern**: Structured API interactions
- **HTTP Status Codes**: Proper RESTful response handling

## Features

- User registration and authentication
- JWT-based authorization
- Role-based access control (Employer/Admin roles)
- Job posting functionality
- Job search by keywords
- Secured endpoints based on user roles

## Architecture

- **Controller Layer**: API endpoints for user registration, authentication, and job operations
- **Service Layer**: Business logic implementation
- **Repository Layer**: Data access using Spring Data JPA
- **Config Layer**: Security configuration and beans
- **Model Layer**: Entity classes representing the domain model
- **Filter Layer**: JWT authentication filter for securing endpoints

## Security Implementation

- Stateless authentication using JWT
- Role-based authorization with Spring Security
- Password encryption
- Protected endpoints requiring specific roles

## API Endpoints

- `/auth/user/register` - User registration
- `/auth/user/login` - User authentication
- `/auth/admin/register` - Admin registration
- `/auth/admin/login` - Admin authentication
- `/addJob` - Add new job (requires EMPLOYER role)
- `/jobPost/allJob` - List all jobs (requires EMPLOYER role)
- `/jobPost/keyword/**` - Search jobs by keyword (requires EMPLOYER role)
- `/loadJobs` - Load jobs (public endpoint)

This project demonstrates proficiency in building secure, scalable backend applications with Spring Boot and implementing proper authentication and authorization mechanisms.