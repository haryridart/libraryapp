# Spring rest API Library Management System



## Technologies

- Java
- Spring boot
- Spring Data JPA
- Swagger
- PostgreSQL

## Features :fire:
- Add a new Book
- Update and Delete based on book ID
- Borrow a book
- Get All books with/without filter status

## How to use (IF YOU WANT TO USE IT LOCALLY)

To clone and run this application by yourself, make sure you have at least Java 8 and all JDK resources (including JRE), Maven to build the dependencies, Intellij or
Ecplise (IDE). After that, do the following instructions

- Clone this repository
```bash
$ git clone https://github.com/haryridart/libraryapp.git
```
- Open this project using Eclipse or Spring tool Suit

- Make sure to create a database called **libraryapp_db** in your postgresql with this command
  > ```CREATE DATABASE libraryapp_db;```
- Or you can import the sql file into your postgresql 
  >```The sql file in this directory with name libraryapp_db.sql```
- Run ```LibraryAppApplication.java```
  > This is going to build the maven dependencies
- The tables of the database will automatically generated when the application is running
- The endpoints are located in 'http://localhost:8080/' and config its port on ```src/main/resources/application.properties```

**Now, you are able to run this Java application locally.**

# API Documentation

Swagger is responsible to provide a documentation of the API, it break down the endpoints and the models of the application.
Open swagger in your browser to test the application  
http://localhost:8080/swagger-ui.html

![img_1.png](img_1.png)

Enjoyy!! You can test the application

Author: Hary Ridart
Email : hary.teguh@ui.ac.id


