<h2>Work in progress!</h2>

 If you want to deploy with embedded H2 data server use "spring.profiles.active = development" in the application.properties file. To deploy WAR to the application server with custom data configuration, use "spring.profiles.active = production".

To start working with embedded data server you should launch H2 server from root directory and set location of the saved data in application.properties and in the server settings.

H2 server starts from terminal with command "java -cp h2.jar org.h2.tools.Server". Default address is "http://10.0.5.100:8082/". Use login and password from application.properties file to log in.

Technologies used: Spring (MVC, JPA, Security), Hibernate, Thymeleaf, JUnit, Mockito, jQuery

