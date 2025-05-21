# Use official OpenJDK 17 image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy jar file (replace 'user-service.jar' with your actual jar name)
COPY target/user-service.jar app.jar

# Expose the port your app runs on (default 8080 for Spring Boot)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
