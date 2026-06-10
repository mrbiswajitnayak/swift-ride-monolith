# SwiftRide Monolith

## Overview

SwiftRide is a Bus Booking System built using Spring Boot and follows a monolithic architecture. The application allows users to register, authenticate using JWT, search buses, book tickets, cancel bookings, and manage transportation-related operations through secure REST APIs.

## Features

* User Registration and Login
* JWT Based Authentication and Authorization
* Role-Based Access Control (USER, VENDOR)
* Bus Management
* Bus Search by Source and Destination
* Ticket Booking
* Booking Cancellation
* Automatic Seat Availability Management
* Global Exception Handling
* Swagger/OpenAPI Documentation
* MySQL Database Integration

## Tech Stack

* Java 17
* Spring Boot 3
* Spring Security
* JWT
* Spring Data JPA
* Hibernate
* MySQL
* Swagger / OpenAPI
* Maven
* Docker

## Project Structure

```text
src/main/java/com/swiftride

├── auth
├── booking
├── bus
├── config
├── dto
├── exception
├── security
├── user
└── vendor
```

## API Modules

### Authentication

* POST /auth/register
* POST /auth/login

### Bus Management

* POST /buses
* GET /buses
* GET /buses/search

### Booking Management

* POST /bookings
* GET /bookings/user/{userId}
* DELETE /bookings/{bookingId}

## Security

The application uses:

* BCrypt Password Encoding
* JWT Token Authentication
* Stateless Session Management
* Spring Security Filter Chain

## Swagger Documentation

Swagger UI:

http://localhost:8080/swagger-ui/index.html

## Future Enhancements

* Kafka Based Notifications
* Vendor Dashboard
* Payment Integration
* Docker Compose Setup
* Unit and Integration Testing
* Microservices Migration

## Author

Biswajit Nayak
