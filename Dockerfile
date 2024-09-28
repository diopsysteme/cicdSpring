FROM openjdk:21
WORKDIR /app
COPY target/schoolappjava-0.0.1-snapshot.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
