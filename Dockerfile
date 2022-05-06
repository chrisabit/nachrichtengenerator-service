FROM maven:eclipse-temurin AS build
WORKDIR /app
COPY spring-nagen /app/
RUN mvn clean package

FROM openjdk:17-jdk-alpine
COPY --from=build /app/target/*jar app.jar
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]