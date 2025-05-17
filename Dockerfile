# -------- Stage 1: Build --------
FROM maven:3.9.6-openjdk-21 AS build

# Set working directory
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src

# Build the application (skip tests to speed up)
RUN mvn clean package -DskipTests

# -------- Stage 2: Run --------
FROM openjdk:21-slim

# Set working directory
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/app.jar app.jar

# Expose Spring Boot default port
EXPOSE 8080

# Start the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
