# Java Frame CRUD Operation

This is a **Java GUI** based desktop application for **User Management** using **CRUD operations (Create, Read, Update, Delete)**. It provides a simple user interface built with Java's `JFrame`, and interacts with a **MySQL database** to manage user records.

## Features

- **Add User:** Insert new user data (e.g., name, email, phone) into the database.
- **View Users:** Display all user records in a table.
- **Update User:** Modify user details using form input.
- **Delete User:** Remove specific user entries from the database.

## Tech Stack

- **Programming Language:** Java
- **Database:** MySQL
- **Database Connectivity:** JDBC (Java Database Connectivity)

## Requirements

- Java JDK 8 or later
- MySQL Server
- MySQL JDBC Driver (Connector/J)
- IDE like NetBeans or IntelliJ IDEA (optional)

## Installation & Setup

### 1. Clone the Repository

```bash
git clone https://github.com/sujitchavda01/JAVA-FRAME-CRUD-OPERATION.git
```

###2. Setup MySQL Database

-Create a database named userdb.
-Create a table users with the appropriate fields.
#Example SQL:
```bash
CREATE TABLE users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  email VARCHAR(100),
  phone VARCHAR(15)
);
```

###3. Configure JDBC Connection

-In the project, locate the database connection section (usually in a file/class like DBConnection.java) and update the credentials:

```bash
String url = "jdbc:mysql://localhost:3306/userdb";
String username = "your_mysql_username";
String password = "your_mysql_password";
```

###4. Run the Application

-Open the project in your preferred IDE (NetBeans, IntelliJ IDEA, Eclipse, etc.).
-Compile and run the project.
-The GUI window will open with options to Add, View, Update, and Delete users.



![Screenshot 2024-06-29 170811](https://github.com/sujitchavda01/JAVA-FRAME-CRUD-OPERATION/assets/144345082/12e62b01-82c5-40d5-851e-a69ae52b2c10)
![Screenshot 2024-06-29 170821](https://github.com/sujitchavda01/JAVA-FRAME-CRUD-OPERATION/assets/144345082/d127398d-5769-4fba-865d-f97d36b95828)
![Screenshot 2024-06-29 170829](https://github.com/sujitchavda01/JAVA-FRAME-CRUD-OPERATION/assets/144345082/69821851-d715-4d64-b274-04ff79c670f8)
![Screenshot 2024-06-29 170754](https://github.com/sujitchavda01/JAVA-FRAME-CRUD-OPERATION/assets/144345082/1e20ab45-a47c-4a0f-86f4-ccfcb947b750)



