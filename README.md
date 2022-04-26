<div id="top"></div>

<!-- Structure Demo Spring -->
<br />
<div align="center">
  <a href="https://github.com/Sholontla">
  </a>

<h3 align="center">Structure Demo Spring</h3>

  <p align="center">
   This Structure Demo is use for testing and demostration to understad the full Demo Structure please visit the diagram: https://github.com/Sholontla/structure-demo-configurations/blob/main/diagram-demo.pdf
    <br />
    <br />
  </p>
</div>

<!-- ABOUT THE PROJECT -->
## About The Project

The Main Project is structure, and the GateWay, Eueraka Server and main Api's are buld on Java and Spring.

<p align="right">(<a href="#top">back to top</a>)</p>

### Built With

* Java 
* Spring 

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- GETTING STARTED -->
## Services:

1. Config Server:
  * First service to run.
  * This service is Cloud Native connections

2. Eureka Discovery Server:
  * Second service to run.
  * Eureka Discovery Servers

3. Spring GateWay:
  * Third service to run.
  * manage port services assign by Eureka Spring Server
  * port: 6000

4. Security Service:
  * Fourth service to run.
  * AES Encryption / Obfuscation service
  * Data filter by group
  * Data Base: Postgre Sql
  * port: manage by Eureka Server

5. configuration Data Base:
  * Fifth service to run.
  * Configuration of Databases
  * Data Base: Local
  * port: manage by Eureka Server

6. Secre Vault Demo:
  * Sixth service to run.
  * Keep Secure and confidentail data
  * Data Base: Mongo DB
  * port: manage by Eureka Server


### Endpoints and Swagger

* localhost:6000/security-ws/security
* localhost:6000/security-ws/security/login
* localhost:6000/security-ws/security/status/check
* localhost:6000/security-ws/security/encryption
* localhost:6000/security-ws/security/obfuscation
* localhost:6000/security-ws/security/{id}
* localhost:6000/security-ws/security/group?group=(select group: 0,1,2,3,4,5,6,7,8,9)
* localhost:6000/security-ws/security/actuator/**
* localhost:6000/security-ws/actuator/circuitbreakerevents
* The Swagger UI can be seen at http://localhost:[port manage by Eureka Server]/swagger-ui/index.html


### Prerequisites
Virtualization / Containers
* Docker
* Docker - Compose

O/I
* Windows
* Linux

## License

For testing and demostrations purposes.


<!-- CONTACT -->
## Contact

Gerardo Ruiz Bustani - solbustani@gmail.com - 442 488 6193 

Project Link: [https://github.com/Sholontla](https://github.com/Sholontla/structure-demo)

