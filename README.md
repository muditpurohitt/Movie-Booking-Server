# Movie-Booking-Server

###Use-
This application is designed to book movie tickets 

###Tech Stack, Libraries Language-
The project is built in Java using SpringBoot and MySql is used for Database.
IDE used is intellij and Maven as project management tool.
Libraries such as Bycrypt and JPT are used.

###Functionalities-
The project has two major functionalitites as of now-
   (a) User login and signup (handeled by UserController)
   (b) Booking a ticket given showId, UserId and seatId.

###Project Structure
(a) It has a main file that calls the BookingController and UserController
(b) Controller Package- This contains two classes, BookingController and UserController. The function of these classes it to act as mediator between service layer and the client.
(c) Models - This package contains various models/ classes that are created as table in the database.
(d) Exceptions - This contains exceptions used by service layer.
(e) Services - This package contains the bussiness logic and contains the algorithms to book tickets and login or sign a user up.
(d) repositories- This package contains the interfaces that extend JPA and interact with MySQL db to read and write data as requested by services.

