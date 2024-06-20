# Hotel Management System

### Student 
Yaqeen Issa  1201576
Ramiz Wasaya 1180903

## Project Overview

The Hotel Management System is designed to streamline operations for both hotel employees and guests. It offers functionalities for customers, such as searching for available rooms, making reservations, checking in and out, and generating invoices. Employees can manage room availability, maintain customer profiles, and oversee housekeeping schedules. This project includes a set of RESTful APIs built with Spring Boot to enable the development of frontend interfaces for web and mobile platforms.

## Features

1. **Customer Management**: Register, login, and manage user profiles.
2. **Employee Management**: Admins can manage hotel employees and staff.
3. **Search**: Search reservations, customer info, and available rooms with details.
4. **Reservation**: Book, modify, and cancel reservations. Cancellation requires admin approval.
5. **Room Management**: Manage room types, availability, and status.
6. **Check-In/Check-Out**: Manage customer arrivals and departures.
7. **Housekeeping Management**: Schedule and track housekeeping tasks.
8. **Billing**: Generate and manage invoices for customer reservations.
9. **Role-Based Access Control**: Different functionalities based on user roles (admin, customer).
10. **Security**: APIs secured using JWT with public and authenticated/authorized access.
11. **API Versioning**: Three different versioning approaches implemented.



## Project Structure

- **Backend**: Implemented using Spring Boot.
- **Database**: Designed based on the tutorial:
- **Docker**: Application and database run using Docker and Docker Compose.
- **API Documentation**: Documented using OAS 3.1.0 standards.
- **Postman Collection**: Prepared to simulate user journeys and test all implemented APIs.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- Docker
- Docker Compose

### Building the Application

1. **Clean and Install the Project**:

    ```bash
    mvn clean install
    ```

2. **Run the Application**:

    ```bash
    java -jar target/hotel-management-system-0.0.1-SNAPSHOT.jar
    ```

### Running with Docker

1. **Build the Docker Image**:

    ```bash
    docker build -t hotel-management-system .
    ```

2. **Run the Application with Docker Compose**:

    ```bash
    docker-compose up
    ```

## Database Design

The database design includes tables for Guest, Employees, Room, booking, Housekeeping, and Invoices. The relationships between these entities are managed using proper foreign key constraints.

## API Documentation

The API documentation follows the OAS 3.1.0 standards. The documentation includes details about each endpoint, request and response formats, and authentication requirements.


## Postman Collection

A Postman collection has been prepared to simulate the user journey on the system interface. The collection includes tests for all implemented APIs.

### Import Postman Collection

1. Download the Postman collection from the GitHub repository.
2. Open Postman and import the collection.

## Learnings

From this project, we have learned:

1. How to design and implement RESTful APIs using Spring Boot.
2. The importance of role-based access control and security using JWT.
3. How to create Docker images and manage services using Docker Compose.
4. Effective use of Git for version control and collaboration.


## ERD 
![image](https://github.com/RamizWas/Hotel_Management_System/assets/121451794/6842e913-d1ce-41ae-9da0-b3ec502b6475)



   
