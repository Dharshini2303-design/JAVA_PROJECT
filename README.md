# 🎬 Movie Database Management System

A simple Java Console Application developed using **Java, JDBC, and MySQL** to perform CRUD (Create, Read, Update, Delete) operations on a movie database.

## 📌 Features

- ➕ Add a new movie
- 📄 View all movies
- 🔍 Search movies by year *(can be implemented)*
- 🎥 Search movies by director *(can be implemented)*
- ✏️ Update movie music *(can be implemented)*
- ❌ Delete a movie *(can be implemented)*

## 🛠 Technologies Used

- Java
- JDBC (Java Database Connectivity)
- MySQL
- PreparedStatement
- Eclipse / VS Code / IntelliJ IDEA

## 📂 Project Structure

```
MINIPROJECTJAVA/
│
├── DBConnect.java
├── movie_Project.java
├── .gitignore
└── README.md
```

## 🗄 Database Setup

### Create Database

```sql
CREATE DATABASE kongu;
USE kongu;
```

### Create Table

```sql
CREATE TABLE movie (
    movie_id INT AUTO_INCREMENT PRIMARY KEY,
    myname VARCHAR(100),
    myyear INT,
    mydirector VARCHAR(100),
    mymusic VARCHAR(100)
);
```

## ⚙ Database Configuration

Update the database credentials in the Java file if necessary.

```java
static final String url = "jdbc:mysql://localhost:3306/kongu";
static final String user = "root";
static final String password = "your_password";
```

## ▶ How to Run

1. Install Java JDK.
2. Install MySQL Server.
3. Create the database and table.
4. Add the MySQL JDBC Connector JAR to your project.
5. Compile the Java files.

```bash
javac movie_Project.java
```

6. Run the application.

```bash
java movie_Project
```

## 📋 Menu

```
--- Movie Database Menu ---

1. Add Movie
2. View All Movie
3. Search Movie by Year
4. Search Movie by Director
5. Update Music
6. Delete Movie
7. Exit
```

## 📸 Sample Output

```
Connection started Successfully

--- Movie Database Menu ---

1. Add Movie
2. View All Movie
3. Search Movie by Year
4. Search Movie by Director
5. Update Music
6. Delete Movie
7. Exit

Enter Choice: 1

Enter Movie Name:
Leo

Enter Movie Year:
2023

Enter Movie Director:
Lokesh Kanagaraj

Enter Movie Music:
Anirudh

Movie added successfully
```

## 🚀 Future Enhancements

- Search movie by name
- Update movie details
- Delete movie records
- User Login Authentication
- GUI using Java Swing or JavaFX
- Export movie list to PDF/Excel
- Exception handling improvements

## 📖 Learning Outcomes

This project helped in understanding:

- JDBC Connectivity
- MySQL Database Operations
- CRUD Operations
- Java Exception Handling
- PreparedStatement
- ResultSet
- Menu-Driven Console Applications

## 👩‍💻 Author

**Dharshini G**

B.Tech Information Technology

Java | JDBC | MySQL | Git | GitHub

---
⭐ If you like this project, don't forget to give it a Star on GitHub!
