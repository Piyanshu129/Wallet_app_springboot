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

