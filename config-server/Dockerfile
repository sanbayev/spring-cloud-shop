FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /build
COPY ../pom.xml ./
COPY ../config-server ./config-server
RUN mvn -f config-server/pom.xml clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
RUN apk add --no-cache curl
WORKDIR /app
COPY --from=builder /build/config-server/target/*.jar app.jar
COPY ../config-repo ./config-repo
ENTRYPOINT ["java", "-jar", "app.jar"]
