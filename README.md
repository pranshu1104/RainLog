## RainLog / RainScape – Smart Waterlogging Monitoring Backend
A backend system for ingesting, processing, and analyzing location-based waterlogging data to support real-time monitoring and decision-making.
## Overview
RainLog is a backend-driven system that collects geospatial event data (latitude, longitude, severity), validates and transforms it, and stores it for further analysis.
The system converts raw inputs into structured insights using:

* Severity classification (LOW / MEDIUM / HIGH)
* Spatial grid mapping (custom cell IDs)

This enables location-aware understanding of waterlogging conditions.
## Architecture
The project follows a layered architecture:
Controller → Service → Repository → Database

* Controller Layer → Handles HTTP requests
* Service Layer → Business logic, validation, transformations
* Repository Layer → Data persistence via JPA
* Database → H2 in-memory database

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* Hibernate (ORM)
* H2 Database
* AWS EC2 (Deployment)

## API Endpoints## 1. Add Waterlogging Report
POST /reports

{
  "latitude": 28.50,
  "longitude": 77.00,
  "severity": 5
}


* Validates input
* Classifies severity
* Computes spatial cell ID
* Stores in database

## 2. Get All Reports
GET /reports
Returns all stored reports:

[
  {
    "cellId": "2850:7700",
    "latitude": 28.5,
    "longitude": 77.0,
    "severity": 5,
    "level": "MEDIUM"
  }
]

## Core Features

* RESTful API for data ingestion and retrieval
* Input validation for geospatial constraints
* Severity classification logic
* Custom spatial grid mapping (cell ID computation)
* Clean layered backend architecture
* ORM-based persistence (no manual SQL)

## Spatial Processing Logic
The system maps geographic coordinates into grid cells:

int latCell = (int)Math.floor(latitude / GRID_SIZE);int lngCell = (int)Math.floor(longitude / GRID_SIZE);

This enables:

* Spatial grouping
* Efficient analysis
* Future scalability for clustering / heatmaps

## Deployment
The backend is deployed on AWS EC2, making the APIs publicly accessible.
Key Steps:

   1. Launched EC2 instance (t3.micro)
   2. Configured security group (opened port 8080)
   3. Deployed Spring Boot JAR
   4. Verified APIs via browser & Postman

## Testing
Tested using:

* Browser (GET requests)
* Postman (POST requests)

## Sample Workflow

   1. Send POST request → /reports
   2. Backend processes data
   3. Data stored via JPA
   4. Retrieve via GET /reports

## What This Project Demonstrates

* Backend system design
* REST API development
* Data validation & transformation
* Object-relational mapping (JPA/Hibernate)
* Cloud deployment (AWS EC2)
* Real-world backend workflow

## Future Improvements

* Add persistent database (MySQL / PostgreSQL)
* Integrate frontend (map visualization)
* Implement real-time updates
* Add authentication & security
* Deploy using Docker

## Author
Pranshu Malhotra
B.Tech CSE | Java Backend Developer
If you found this interesting, feel free to star the repo!


