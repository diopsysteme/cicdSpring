# Step 1: Build the application using Maven in a builder container
FROM maven:3.9.0-openjdk-21 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the application source code into the container
COPY . .

# Build the application (this will generate the JAR file in the target directory)
RUN mvn clean package -DskipTests

# Step 2: Use a lightweight OpenJDK image to run the application
FROM openjdk:21-jdk-slim

# Set the working directory for the runtime container
WORKDIR /app

# Copy the JAR file from the builder container
COPY --from=builder /app/target/schoolappjava-0.0.1-snapshot.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
