API-endpoint 
Spring Boot application implementing an API endpoint /echo/{customerNumber}

Requirements
Java 23 or higher
Maven 3.6+ for dependency management and building the project

Instructions 
1)Clone the repo - 
git clone https://github.com/yourusername/echo-api.git
cd echo-api

2)Build project -
mvn clean install

3)Run the app-
mvn spring-boot:run

(If in case the default port is busy, navigate to src/main/resources/ open application.properties and change the port by typing server.port=<custom_port> )
(The return type of echo() is map however due to jackson the map is implicitly converted to json by spring)


