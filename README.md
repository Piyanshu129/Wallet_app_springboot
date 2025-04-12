# Wallet Application (Spring Boot)

**Description**  
A comprehensive Wallet Application built on **Spring Boot** providing essential digital wallet functionalities. It features user registration, deposits, withdrawals, transaction history, and robust exception handling. With secure data management and RESTful endpoint mappings, this application showcases best practices in back-end architecture and design.

---

## Features

1. **User Registration & Login**  
   - Create new user accounts (username, email, password).  
   - Secure authentication (session-based or JWT-based, depending on your setup).

2. **Balance Management**  
   - **Deposit**: Increase the wallet balance.  
   - **Withdraw**: Decrease the wallet balance, with checks for sufficient funds.

3. **Transaction History**  
   - Display all transactions with timestamps and amounts.  
   - Optional filters (e.g., transaction date range).

4. **Exception Handling**  
   - **Global Exception Handling**: A centralized approach using `@RestControllerAdvice` to capture and handle exceptions across the application.  
   - **Custom Exceptions**: For scenarios like insufficient funds or user not found, returning clear, standardized error responses.  
   - **HTTP Status Codes**: Well-defined status codes (`400`, `404`, `409`, `500`, etc.) for precise client-side error handling.

5. **Entity & Endpoint Mapping**  
   - **Entity Mapping**: JPA/Hibernate annotations (`@Entity`, `@Table`, `@OneToMany`, etc.) for clear database relationships.  
   - **Endpoint Mapping**: RESTful routes (using `@RestController`, `@RequestMapping`, `@GetMapping`, `@PostMapping`, etc.) to provide clean, versioned APIs (e.g., `/api/v1/wallet/...`).

---

## Technologies Used

- **Backend**:  
  - [Spring Boot](https://spring.io/projects/spring-boot)  
  - [Spring Data JPA](https://spring.io/projects/spring-data-jpa) / [Hibernate](https://hibernate.org/)  
  - [Spring Security](https://spring.io/projects/spring-security) *(optional but recommended)*  

- **Database**:  
  - [MySQL](https://www.mysql.com/) or [PostgreSQL](https://www.postgresql.org/)  
  - [H2 Database](https://www.h2database.com/) (in-memory, for testing)  

- **Build Tool**:  
  - [Maven](https://maven.apache.org/) or [Gradle](https://gradle.org/)

- **IDE** (Optional):  
  - IntelliJ, Eclipse, NetBeans, or VSCode with Java support

---

## Project Structure


- **controller**: Houses REST controllers (`WalletController`, `AuthController`).  
- **exception**: Contains custom exception classes (`InsufficientFundsException`, `UserNotFoundException`, etc.) and a global handler (`GlobalExceptionHandler`).  
- **model**: Holds entity classes (`User`, `Transaction`).  
- **repository**: Spring Data JPA repositories (e.g. `UserRepository`, `TransactionRepository`).  
- **service**: Contains the business logic (e.g., transaction validation, user management).  

---

## Getting Started

### Prerequisites

1. **Java 8** or higher  
2. **Maven** or **Gradle**  
3. A **MySQL** (or other) database installed and configured (unless using H2 for testing)

### Installation & Setup

1. **Clone the Repository**  
   ```bash
   git clone (https://github.com/Piyanshu129/Wallet_app_springboot.git)
   cd wallet-app-springboot

