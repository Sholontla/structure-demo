# structure-demo
. Structure Demo
As part of my CV "code" experience I been added this Structure Demo and is always growing, change, and use for testing and more and as part of this chage new ideas are being implemented and to understad the full Demo Structure please visit the diagram: 

In the repo: 
all the structure is been tidy by the next order:

  1. service-config-server 
    Manage spring cloud for properties and configurations of services and dependencies.
   
  2. eureka-discovery-service.
    manage all services.
    port: 
      8000
    
  3. service-gateway
    mange service eureka portand validate JWT
    port: 
      6000
      
  4. securiy-service
    service that Obfuscate (change values by any String) and Encrypt (Symple AES implemetation)
    port:
      manage by Eureka server
    end-points:
      localhost:6000/security-ws/security
      localhost:6000/security-ws/security/login
      localhost:6000/security-ws/security/status/check
      localhost:6000/security-ws/security/encryption
      localhost:6000/security-ws/security/obfuscation
      Swagger:
        True
        
  5. secure-vault-demo
      service API manage all the sensitive data.
    port:
      manage by Eureka server
    Swagger:
      True
   
   
 ***** AS PART OF CHANGE & TEST THIS COMPLMENTS ARE STILL ON DEVELOP *************************
 
  6. database-configurations
    manage all drivers and configurations that Api security-service required.
    
  7. metadata-demo
    manage the API Security servie required all the logic, columns, and informations that the service required to to de process 

