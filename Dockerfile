FROM openjdk:15-jdk-alpine
ENTRYPOINT ["java","-jar","/target/api-chatter-0.0.1-SNAPSHOT.jar"]