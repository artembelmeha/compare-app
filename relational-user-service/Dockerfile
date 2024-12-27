FROM openjdk:17
ADD ./relational-user-service/target/relational-user-service-0.0.1-SNAPSHOT.jar relational-user-service.jar
EXPOSE 8005
ENTRYPOINT ["java", "-jar", "/relational-user-service.jar"]
