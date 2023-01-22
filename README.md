
# Bus Reservation System(EcoMove Bus) 
<img src="https://media.tenor.com/-r7rOH-I6V8AAAAM/india-overload.gif"  style = "width:90%; height:450px" />

* Bus Reservation System is a full stack project where REST API's are developed using Java and Spring Boot technologies and UI or frontend is developed using HTML,CSS,JavaScript
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



# ER Diagram

The following Diagram depicts the flow of our Entity Relation Diagram to simplify the work flow.
<br>![NewER](https://github.com/Hartumpa/plant-grain-8335/blob/main/Images/ER_Diagram.jpg)
<br>
<br>
<br>


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
        



# 👉 [Click here for Vedio Presentation](https://drive.google.com/drive/folders/1XSkfZn0PNHGS_G8e5Vhg29dGoLHnat-g?usp=sharing) to get better understanding of the application.

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

## Admin Module
<img width="944" alt="https://github.com/Hartumpa/plant-grain-8335/blob/main/Images/Admin_Module_Pic.png">

## User Module
<img width="938" alt="https://github.com/Hartumpa/plant-grain-8335/blob/main/Images/UserModule.png">

## Route Module
<img width="941" alt="https://github.com/Hartumpa/plant-grain-8335/blob/main/Images/RouteModule.png">

## Bus Module
<img width="941" alt="https://github.com/Hartumpa/plant-grain-8335/blob/main/Images/BusModule.png">

## Reservation Module
<img width="940" alt="https://github.com/Hartumpa/plant-grain-8335/blob/main/Images/ReservationModule.png">

## Feedback Module
<img width="943" alt="https://github.com/Hartumpa/plant-grain-8335/blob/main/Images/FeedBackModule.png">
   

 


# THANK YOU FOR VISITING OUR PROJECT

