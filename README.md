# spring-cloud-demo
This repository will hold spring cloud related code and demo examples

# Eureka Server 
 this is a spring boot application in which @EnableEurekaServer annotation is used to define this is a eureka server application. By defualt eureka server port is 8761
 
 Run- to run this application type mvn spring-boot:run
 Open browser with http://localhost:8761/  -it will shoe eureka server application details and health details.
 
# User Service
 this is another spring boot application which will expose user resource through REST api's and also it register it self on Eureka server using annotation @EanbleClientDiscovery

Run- to run this application type mvn spring-boot:run
open Browser with http://localhost:9090/  - it will give response as Hello World from user service


#User Client 
  another spring boot application which will use discoveryClient to get User service instance URL and then specific URL.
  Run- to run this application type mvn spring-boot:run
  If you hit http://localhost:8085/ it will print no of user service appllication instances running. and when you hit http://localhost:8085/hello then it will call user service first instance and return back response from user service along with user client response.
  
  
  We will have client side load balancing and circuit breaker in next few days.
