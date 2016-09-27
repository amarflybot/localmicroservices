# This repository shall contain only server side code.

This note demonstrates some of what [Micro Services][1] is capable of doing.

*Note: This architecture demonstrates the basics of Spring Micro Services for distributed application.*

## Server Side Architecture

Microservices allow large systems to be built up from a number of collaborating components. It does at the process level what Spring has always done at the component level: loosely coupled processes instead of loosely coupled components.

## List of Spring-Cloud Services used
### 1. Distributed/versioned configuration
### 2. Service registration and discovery
### 3. Routing
### 4. Service-to-service calls
### 5. Load balancing
### 6. Circuit Breakers
### 7. Distributed messaging

## Prerequisites
Download and Install [Redis][2]


## Order of Services to run
1. config-service
2. eureka-service
3. hystrix-dashboard
4. person-service
5. person-client

Urls: Config Server: http://localhost:8888/person-service/master
      Eureka Registry server: http://localhost:8761  
      Hystrix Server: http://localhost:8080/hystrix.html
      Person Server: http://localhost:8000/persons
      Person Client (Get): http://localhost:8032/persons/names
      Person Client (Post): http://localhost:8032/persons/        
      
      POST /persons/ HTTP/1.1
      Host: localhost:8032
      Accept: application/json
      Content-Type: application/json
      Cache-Control: no-cache
      Postman-Token: 7f459e2e-2b44-8217-8089-7b8cb4f7b33e
      
      {
      "personName":"Amarendra"
      }
      
  [1]: https://spring.io/blog/2015/07/14/microservices-with-spring
  [2]: http://redis.io/topics/pubsub