FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /build
COPY ../pom.xml ./
COPY ../user-service ./user-service
RUN mvn -f user-service/pom.xml clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /build/user-service/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
