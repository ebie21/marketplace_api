# Marketplace API 🛒
A Spring Boot REST API for a multi-vendor marketplace,

## 🚀 Features
* **User & Category Management:** Full CRUD for users and product categories.
* **Product Management:** Secure product creation linked to specific users and categories.
* **Security:** Ownership-based authorization (users can only update/delete their own products).
* **Validation:** Robust input validation using Hibernate Validator.
* **Global Error Handling:** Clean JSON error responses for all API exceptions.

## 🛠️ Tech Stack
* **Java 21 / Spring Boot 3**
* **Spring Data JPA** (Hibernate)
* **MySQL Database**
* **Maven**

## ⚙️ Setup & Installation
1. Clone the repository.
2. Create a MySQL database named `marketplace_db`.
3. Update `src/main/resources/application.properties` with your database credentials.
4. Run `./mvnw spring-boot:run`.

## 📌 API Endpoints (Quick Look)
### Products
* `GET /api/products` - List all products
* `POST /api/products` - Create a product (Requires `userId` and `categoryId`)
* `PUT /api/products/{id}` - Update a product (Requires ownership check)
* `DELETE /api/products/{id}?userId={userId}` - Delete a product
