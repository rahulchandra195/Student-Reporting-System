# Students Reporting System 
Students Reporting System  spring boot application

*** Technologies and Dependencies Used
- Java (Efficient language to handle backend operations)
- Spring Boot (used to build hassle free web applications and writing REST APIs.)
- Spring Data JPA (Used to reduce the time of writing hardcoded sql queries and instead allows to write much more readable and  scalable code )
- MySQL (used as a Java persistence store)


** Features

- Student can be registered
- User can see Average Percentage of whole class in recent semester
- User can Average marks of Students in a subject
- User Top 2 Consistent Students across all semesters (Maximum average marks)

 ** Packages and classes **

** classes in Controller package
- StudentCotroller class

** Classes in Exception package

- StudentException 
- ErrorDetails
- GlobalException

** Classes in Repository package

- StudentRepo 

** Classes and Interfaces in Service package

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

*** API Root Endpoint
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


