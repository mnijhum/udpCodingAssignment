# udpCodingAssignment

##How to run the project

###Technology used:
I have used Java 17 and intellij idea for this project. So please download and install java 17 and intellij idea first.
### Database Configuration:
1. Connect to any MySQL server using xampp or wampp and remeber the port number
2. Create a database named "udpassignment" in your localhost and leave as it is.

###Starting the server
1. Clone this repository in your local machine.
2. If you downloaded the zip file, unzip it and right click on udpCodingAssignment folder and open as a project via intellij Idea.
3. Go to ```src/main/resources``` and open ```application.yml``` 
4. Find the line: ```url: jdbc:mysql://${DB_HOST:localhost}:${DB_PORT:3306}/udpassignment?serverTimezone=UTC``` and check the ```DB_PORT:```
5. If your port matches with 3306 then leave it as it is otherwise replace it with yours.
6. Simply find UdpCodingAssignmentApplication and right click on it and run.
7. Here in ```/src/main/resources``` the ```import.sql``` file contains some data which will automatically be added to your database when you run the application. 


 
