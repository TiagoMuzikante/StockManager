FROM maven:3.9.9-eclipse-temurin-23 AS build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app
RUN mvn clean install

FROM eclipse-temurin:23-jre-alpine

COPY --from=build /app/target/StockManager-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]