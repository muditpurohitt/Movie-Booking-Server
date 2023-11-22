# Movie-Booking-Server

### Use<br>
This application is designed to book movie tickets<br>

### Tech Stack, Libraries Language<br>
+ The project is built in Java using SpringBoot and MySql is used for Database.<br>
+ IDE used is intellij and Maven as project management tool.<br>
+ Libraries such as Bycrypt and JPT are used.<br>

### Functionalities<br>
The project has two major functionalitites as of now-<br>
+ User login and signup (handeled by UserController)<br>
+ Booking a ticket given showId, UserId and seatId.<br>

### Project Structure-<br>
+ It has a main file that calls the BookingController and UserController<br>
+ Controller Package
    + This contains two classes, BookingController and UserController. The function of these classes it to act as mediator between service layer and the client.<br>
+ Models 
    + This package contains various models/ classes that are created as table in the database.<br>
+ Exceptions 
    +  This contains exceptions used by service layer.<br>
+ Services 
    + This package contains the bussiness logic and contains the algorithms to book tickets and login or sign a user up.<br>
+ Repositories
    + This package contains the interfaces that extend JPA and interact with MySQL db to read and write data as requested by services.<br>

