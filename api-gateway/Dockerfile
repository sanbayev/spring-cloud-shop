FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /build
COPY ../pom.xml ./
COPY ../api-gateway ./api-gateway
RUN mvn -f api-gateway/pom.xml clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /build/api-gateway/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]