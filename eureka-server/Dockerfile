FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /build
COPY ../pom.xml ./
COPY ../eureka-server ./eureka-server
RUN mvn -f eureka-server/pom.xml clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /build/eureka-server/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
