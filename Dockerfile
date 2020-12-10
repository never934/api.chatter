#
# Build stage
#
FROM maven:3.6.3-openjdk-15-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:15-slim
COPY --from=build /home/app/target/api-chatter.jar /usr/local/lib/api-chatter.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/api-chatter.jar"]