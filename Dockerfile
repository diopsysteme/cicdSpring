FROM openjdk:22-jdk
WORKDIR /app

COPY target/schoolappjava-0.0.1-snapshot.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
