# PetVaccinationTrackingSystem

This project is a Spring Boot-based RESTful web application that manages pet vaccination records. It supports adding, updating, retrieving, and deleting pet information along with their vaccination history.

## 🚀 Tech Stack

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Hibernate**
- **H2 Database (in-memory)**
- **Lombok**
- **Jakarta Validation**
- **Postman** (for API testing)

---

## 📁 Project Structure

```
com.gevernova.petvaccination
├── controller              # REST Controllers
├── dto                    # Request and Response DTOs
├── entity                 # JPA Entities (Pet, Vaccination)
├── exceptions             # Global Exception Handling
├── repository             # JPA Repository
├── service                # Service Interface and Implementation
└── PetVaccinationApplication.java

````

---

## 📦 Features

- ✅ Register a new pet along with its vaccination history
- ✅ Fetch pet details by ID
- ✅ Fetch all pet records
- ✅ Update pet and vaccination details
- ✅ Delete pet by ID
- ✅ Custom exception handling
- ✅ Input validation using Jakarta annotations

---

##  API Endpoints

###  Add New Pet  
`POST /vaccine`  
**Body:** `RequestDTO`  
Returns the saved `Pet` object.

###  Get Pet by ID  
`GET /vaccine/{id}`  
Returns the pet with given ID or error if not found.

###  Get All Pets  
`GET /vaccine/all`  
Returns a list of all registered pets.

###  Update Pet  
`PUT /vaccine/{id}`  
Updates pet and vaccination information.

###  Delete Pet  
`DELETE /vaccine/{id}`  
Deletes the specified pet.

---

## ✅ Validation Rules

- All fields are required.
- Owner contact must be a **valid 10-digit Indian number**.
- Vaccination date must be **in the past or present**.

---

## ❗ Error Handling

Handled globally using `@RestControllerAdvice` .





