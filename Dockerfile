# ---------- STAGE 1: Build ----------
FROM maven:3.9.4-eclipse-temurin-17-alpine AS builder

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies first (layer caching)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the entire project
COPY . .

# Build the project
RUN mvn clean package -DskipTests

# ---------- STAGE 2: Run ----------
FROM eclipse-temurin:17-jdk-alpine

# Install CA certificates package
RUN apk add --no-cache ca-certificates && update-ca-certificates
WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
