FROM openjdk:17
ADD ./user-api/target/user-api-0.0.1-SNAPSHOT.jar user-api.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "/user-api.jar"]
