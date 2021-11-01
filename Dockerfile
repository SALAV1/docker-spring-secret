FROM openjdk:8-jdk-alpine

EXPOSE 8080

RUN mkdir -p /opt/docker-spring-secret

ADD target/docker-spring-secret-0.0.1-SNAPSHOT.jar /opt/docker-spring-secret/application.jar

ENTRYPOINT ["java","-jar", "application.jar"]