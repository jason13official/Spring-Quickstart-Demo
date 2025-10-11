# Spring-Quickstart-Demo

> Created following https://spring.io/quickstart

### Run the code:

- CLI: `./gradlew bootRun`
- IDE: Gradle sidebar -> Tasks -> application -> `bootRun`

### View the endpoints:

> Quote: "Spring Boot’s embedded Apache Tomcat server is acting as a webserver and is listening for
> requests on localhost port 8080. Open your browser and in the address bar at the top
> enter http://localhost:8080/hello"

Opening our endpoints in a browser is a great way to see what the typical end-user would see, but
endpoints can vary wildly and accept different HTTP requests (such as GET, POST, PUT, etc.).

We're utilizing Git BASH (more specifically, emulated Git BASH via "Git for Windows"), which
provides us with [curl](https://curl.se/) natively to send various types of data for our
different endpoints.

Examples:
- `curl --request GET "http://localhost:8080/status/detailed`
- `curl --request POST --data "My New Detailed Status" "http://localhost:8080/status/detailed`
