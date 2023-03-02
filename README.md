# Students Reporting System 
Students Reporting System  spring boot application


![Students_reporting_System](https://user-images.githubusercontent.com/103636217/221101208-be3fbe60-1633-475e-8014-9db4b6f3e529.jpg)

## About
This student management api build to manage the students records and Reports  in the database which make a hassle free management . 


## Features

- Student can be registered
- User can see Average Percentage of whole class in recent semester
- User can Average marks of Students in a subject
- User Top 2 Consistent Students across all semesters (Maximum average marks)


## Technologies and Dependencies Used
- Java (Efficient language to handle backend operations)
- Spring Boot (used to build hassle free web applications and writing REST APIs.)
- Spring Data JPA (Used to reduce the time of writing hardcoded sql queries and instead allows to write much more readable and  scalable code )
- MySQL (used as a Java persistence store)
- Swagger UI (Used to visualize and interact with the API’s resources without having any of the implementation logic in place.)
- Lambok  (Reduces the time  of writing java boiler plate code.)
- Maven (used as a dependency management tool.)

## Backend Design 
###  ER Diagram

![New Microsoft PowerPoint Presentation](https://user-images.githubusercontent.com/101393689/219923240-84f64dae-020a-4909-a18b-6c5018b66b69.jpg)


###  Tables in database

![tables](https://user-images.githubusercontent.com/101393689/219923017-19a96892-bb36-4ec7-ac92-235b4153897d.png)


-Description of Student table

![student](https://user-images.githubusercontent.com/101393689/219923022-7b0f64d5-3a71-4bdf-82d5-24dc436fc430.png)


-Description of Marks table

![marks](https://user-images.githubusercontent.com/101393689/219923024-6f7239eb-be1e-4b0a-bbe6-67517080fdb2.png)




###  Packages and classes

#### classes in Controller package
- StudentCotroller class

#### Classes in Exception package

- StudentException 
- ErrorDetails
- GlobalException

#### Classes in Repository package

- StudentRepo 

#### Classes and Interfaces in Service package

- StudentService(Interface)
- StudentServiceImpl(Class)

## Installation & Run
- Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
    server.port=8080

    spring.datasource.url=jdbc:mysql://localhost:3306/studentdb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

## API Root Endpoint
- To add a student
```
PUT "http://localhost:8080/students"
```
-To see Average Percentage of whole class in recent semester
```
PUT "http://localhost:8080/get_avg_students_marks"
```

-To see Average marks of Students in a subject
```
PUT "http://localhost:8080/get_avg_marks"
```

-To see top 2 Consistent Students across all semesters (Maximum average marks)
```
PUT "http://localhost:8080/top_two_students"
```

-You can also check through swagger ui
```
http://localhost:8080/swagger-ui/
```
