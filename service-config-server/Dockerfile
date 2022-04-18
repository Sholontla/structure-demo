FROM openjdk:11-jdk-alpine
VOLUME /tmp 
COPY apiEncryptionKey.jks apiEncryptionKey.jks
COPY UnlimitedJCEPolicyJDK8/* /mnt/c/java/microservices/git-config-server/config-service-demo/ 
COPY target/service-config-service-0.0.1-SNAPSHOT.jar ConfigServer.jar 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","ConfigServer.jar"] 