
# Bus Reservation System 
<img src="https://media.tenor.com/-r7rOH-I6V8AAAAM/india-overload.gif"  style = "width:90%; height:450px" />

* Bus Reservation System is a full stack project where REST API's are developed using Java and Spring Boot technologies and UI or frontend is developed using HTML,CSS,     JavaScript
*  These API's performs all the fundamental CRUD operations of any Bus Reservation Application platform with user validation at every step.
*  Our frontend application consumes these API's and allows customer to perform all the operations easily with user friendly UI.
* This project is developed by team of 4 Back-end Developers during project week in Masai School. 

## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL


## Modules

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

* Before using the web application or running the API server, you should update the database config inside the [application.properties](https://github.com/Shivaprasad-sBhat/posh-fact-2211/blob/main/BusReservation/src/main/resources/application.properties) file. 
* Update the port number, username and password as per your local database config.

```
    server.port=8818

    spring.datasource.url=jdbc:mysql://localhost:3306/bus_reservation_db
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```
* Now you can perform all the operations by using either our web application or Swagger.

## API Root Endpoint
```
`http://localhost:8818/`
```

```
`http://localhost:8818/swagger-ui.html`
```



   

 


# THANK YOU FOR VISITING OUR PROJECT

