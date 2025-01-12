FROM openjdk:17
ADD ./config-service/target/config-service-0.0.1-SNAPSHOT.jar config-service.jar
EXPOSE 3000
ENTRYPOINT ["java", "-jar", "/config-service.jar"]
