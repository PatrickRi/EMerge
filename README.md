# Intro To Spring Cloud

This is the repository for the Intro to Spring Cloud talk.  

## Using This Repo

There are three directories in this repository:

1. `Intial` - Contains two basic services that are modified to integrate Spring Cloud
2. `Complete` - Finalized Spring Cloud apps 
3.  `config` - Various configuration files picked up by Spring Cloud Config 

### The Services

#### reservation-service
The `reservation-service` app returns a list of reservations under `localhost:8244/reservations` and the reservation's detail under `/reservations/{id}`.

#### speaker-service
The `speaker-service` app returns the speaker identified by an id under `localhost:8222/speakers/{id}`.

#### config-server
Spring Cloud Config server running on `localhost:8888` and exposes the configuration specified in the config directory in this Git repository.

#### eureka-server
Spring Cloud Eureka server running on `localhost:8761`.

#### zuul-server
Spring Cloud Netflix Zuul server running on `localhost:8080`, exposing internal services.

#### Gateway Web App
Spring Cloud Gateway server, basically the same functionality as `zuul-server`.

#### zipkin.jar
Zipkin server, which can directly be started using `java -jar zipkin.jar`.
