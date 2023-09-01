# AskMe

##About

  AskMe is a web application where you can ask questions about what you don't know the answer or you can answer others questions.
  The idea comes from the stack owerflow webpage.

##Status

  This project currently is a Work in Progress. At this moment only the beckend part is ready with database.
  The backend bulit with java spring the database I use H2. The database now is empty but, in the future
  I will ad some question and some answers to it. Spring Security is also implemented.

##Setup
  
  * First you need to clone the repository to your local computer.
  * You can run the application from command line just to be sure you have latest maven version 3.9.4
  * Then in the terminal opnen the project repository and write "mvn spring-boot:run"
    
  * Or if you have InteliJ that is the easiest way to run this application you need to open the pom.xml file as a project and just run the application

##Future plans

  * Add a frontend to it. At this point I didn't decided that should I use React or Vue.
  * Registration and login page.
  * Add user page where the user will be able to change username email or password.

##Technologies

  * Java 17.0.8.1
  * SpringBoot
  * Spring Security with JWT token
  * JPA
  * H2 for database
