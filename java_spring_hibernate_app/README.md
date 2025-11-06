# Java Applications Using Spring and Hibernate
This project demonstrates Spring and Hibernate integration for Dependency Injection, CRUD Operations, and Transaction Management.

## Parts
### Part A: Dependency Injection in Spring Using Java-Based Configuration
- `AppConfig.java` — Java-based Spring configuration.
- `MessageService.java`, `MessageServiceImpl.java`, `App.java` — Demonstrates dependency injection.

### Part B: Hibernate CRUD on Student Entity
- `Student.java`, `HibernateUtil.java`, `StudentDAO.java`, `MainApp.java` — Demonstrates Hibernate CRUD with MySQL.

### Part C: Spring + Hibernate Transaction Management
- `Account.java`, `BankService.java`, `BankServiceImpl.java`, `BankApp.java` — Demonstrates transactional money transfer between accounts.

## Setup Instructions
1. Add the following dependencies in your Maven `pom.xml` or Gradle file:
   - Spring Context, Spring ORM
   - Hibernate Core
   - MySQL Connector/J
   - JPA API
2. Update MySQL credentials in `hibernate.cfg.xml`.
3. Run each part using your IDE or Maven build.
