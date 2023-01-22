
# Bus Reservation System(EcoMove Bus) 
<img src="https://media.tenor.com/-r7rOH-I6V8AAAAM/india-overload.gif"  style = "width:90%; height:450px" />

* Bus Reservation System is a full stack project where REST API's are developed using Java and Spring Boot technologies and UI or frontend is developed using HTML,CSS,     JavaScript
*  These API's performs all the fundamental CRUD operations of any Bus Reservation Application platform with user validation at every step.
*  Our frontend application consumes these API's and allows customer to perform all the operations easily with user friendly UI.
* This project is developed by team of 5 Back-end Developers during project week in Masai School. 

<!-- ============================================  TECH STACK ======================================================  -->

## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Postman
* Swagger UI

<!-- ============================================  MODULES ======================================================  -->

## Modules

* Login, Logout Module
* Admin Module
* User Module
* Route Module
* Bus Module
* Reservation Module
* Feedback Module


<!-- ============================================  FEATURES ======================================================  -->
## Features

* Customer and Admin authentication & validation with session uuid having.
* Admin Features:
    * Administrator Role of the entire application
    * Only registered admins with valid session token can add/update/delete customer from main database
    * Admin can access the details of different customers and trip bookings
* Customer Features:
    * Registering themselves with application, and logging in to get the valid session token
    * Viewing list of available Route and available Bus for a trip
    * Only logged in user can access his reservations, profile updation and other features.
        

## Installation & Run

* Before using the web application or running the API server, you should update the database config inside the [application.properties](https://github.com/Hartumpa/plant-grain-8335/blob/main/EcoMove/src/main/resources/application.properties) file. 
* Update the port number, username and password as per your local database config.


    server.port=8884

    spring.datasource.url=jdbc:mysql://localhost:3306/ecomove
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

* Now you can perform all the operations by using either our web application or Swagger.

## API Root Endpoint

https://localhost:8884/
  
http://localhost:8884/swagger-ui/


## Following pictures will help to understand flow of the Application and API's of Bus Reservation Portal System
<!-- ## Start Point
<img width="957" alt="Screenshot (2376)" src="https://user-images.githubusercontent.com/101354104/209181391-5e015973-fdd3-46da-8c25-e66dcc9b0a6b.png">

## Admin Module
<img width="944" alt="Screenshot (2377)" src="https://user-images.githubusercontent.com/101354104/209181373-dd33a760-085c-4861-93ec-57a7cdf4c874.png">

## User Module
<img width="938" alt="Screenshot (2382)" src="https://user-images.githubusercontent.com/101354104/209181267-0bb48a94-b8e0-43d5-a51c-c944784d5d37.png">

## Route Module
<img width="941" alt="Screenshot (2381)" src="https://user-images.githubusercontent.com/101354104/209181296-17df297f-0316-4ed4-8447-f7a1ad594ede.png">

## Bus Module
<img width="941" alt="Screenshot (2380)" src="https://user-images.githubusercontent.com/101354104/209181319-22cc8857-24e9-4c71-9bc1-37f99d78bc48.png">


## Reservation Module
<img width="940" alt="Screenshot (2379)" src="https://user-images.githubusercontent.com/101354104/209181339-114190a4-49f7-4b66-8e99-18488bc1d982.png">

## Feedback Module
<img width="943" alt="Screenshot (2378)" src="https://user-images.githubusercontent.com/101354104/209181358-585d40ef-eaca-4cef-b430-c243c956f5f9.png"> -->
   

 


# THANK YOU FOR VISITING OUR PROJECT

