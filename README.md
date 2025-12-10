# PhaseZero Catalog Service

A small backend microservice built with **Java** and **Spring Boot** to manage product catalogue data via REST APIs.

---

## **Table of Contents**
1. [Project Overview](#project-overview)  
2. [Technology Stack](#technology-stack)  
3. [Build and Run](#build-and-run)  
4. [Project Design](#project-design)  
5. [API Endpoints](#api-endpoints)  
6. [Example Requests/Responses](#example-requestsresponses)  
7. [Assumptions / Limitations](#assumptions--limitations)

---

## **Project Overview**
This service allows managing products with the following features:

- Add a product with validations (no duplicate partNumber, price & stock ≥ 0)  
- List all products  
- Search products by name (case-insensitive)  
- Filter products by category  
- Sort products by price (ascending)  
- Calculate total inventory value  

The project uses **Spring Boot**, **Spring Data JPA**, and **H2/MySQL** as the database.

---

## **Technology Stack**
- Java 17  
- Spring Boot 3.x  
- Spring Web (REST APIs)  
- Spring Data JPA  
- H2 / MySQL database  
- Lombok  
- MapStruct  
- Maven  

---

## **Build and Run**

### 1. Clone the repository
```bash
git clone https://github.com/<your-username>/phasezero-catalog-service.git
cd phasezero-catalog-service
