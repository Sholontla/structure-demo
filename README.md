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

<details>
  <summary>Project Structure</summary>
  <ol>
    <li>
      <a href="#about-the-project">Structure</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

[![Product Name Screen Shot][product-screenshot]](https://example.com)

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
  * port: manage by Eureka Server

5. configuration Data Base:
  * Fifth service to run.
  * Configuration of Databases
  * Data Base: Postgre Sql
  * port: manage by Eureka Server

6. Secre Vault Demo:
  * Sixth service to run.
  * Keep Secure and confidentail data
  * Data Base: Mongo DB
  * port: manage by Eureka Server

7. Secure vault Demo:
  * Seventh service to run.
  * Secure Vault Demo for senitive data
  * Data Base: Local
  * port: manage by Eureka Server


### Endpoints ans Swagger

localhost:6000/security-ws/security
localhost:6000/security-ws/security/login
localhost:6000/security-ws/security/status/check
localhost:6000/security-ws/security/encryption
localhost:6000/security-ws/security/obfuscation
localhost:6000/security-ws/security/{id}
localhost:6000/security-ws/security/group?group=(select group: 0,1,2,3,4,5,6,7,8,9)
localhost:6000/async/test/status/check
localhost:6000/async/test/data
localhost:6000/async/test/data/async

localhost:6000/security-ws/security/actuator/
localhost:6000/security-ws/actuator/circuitbreakerevents

The Swagger UI can be seen at http://localhost:[port manage by Eureka Server]/swagger-ui/index.html

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

