FROM openjdk:17
ADD ./graph-user-service/target/graph-user-service-0.0.1-SNAPSHOT.jar graph-user-service.jar
EXPOSE 2020
ENTRYPOINT ["java", "-jar", "/graph-user-service.jar"]
